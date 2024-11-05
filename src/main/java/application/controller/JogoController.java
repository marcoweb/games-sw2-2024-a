package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.record.JogoDTO;
import application.record.JogoListDTO;
import application.service.JogoService;

@RestController
@RequestMapping("/jogos")
public class JogoController {
    @Autowired
    private JogoService jogoSrv;

    @GetMapping
    public Iterable<JogoListDTO> list() {
        return jogoSrv.getAllSimple();
    }

    @PostMapping
    public JogoDTO insert(@RequestBody JogoDTO jogo) {
        return jogoSrv.add(jogo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        jogoSrv.deleteById(id);
    }

    @PutMapping("/{id}")
    public JogoDTO update(@PathVariable long id, @RequestBody JogoDTO jogo) {
        return jogoSrv.update(id, jogo);
    }
}
