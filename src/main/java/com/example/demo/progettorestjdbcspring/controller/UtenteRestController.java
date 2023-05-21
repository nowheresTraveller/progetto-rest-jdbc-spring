package com.example.demo.progettorestjdbcspring.controller;

import com.example.demo.progettorestjdbcspring.db.dao.interfaces.GeneralDaoInterface;
import com.example.demo.progettorestjdbcspring.db.dao.interfaces.UtenteDaoInterface;
import com.example.demo.progettorestjdbcspring.db.dao.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utenteRestController")
public class UtenteRestController {

    @Autowired
    @Qualifier("utenteGeneralDaoInterface")
    private GeneralDaoInterface<Utente> utenteGeneralDao;


    @Autowired
    @Qualifier("utenteDaoInterface")
    private UtenteDaoInterface utenteDao;

    @GetMapping("/getById")
    public String getById(@RequestParam("id") Integer id) {
        Utente utente = utenteGeneralDao.selectById(id);
        return utente.getNome() + " " + utente.getCognome();
    }

    @RequestMapping(path = "insert",
            method = RequestMethod.GET)
    public String insert(@RequestParam("nome") String nome, @RequestParam("cogn") String cogn,
                         @RequestParam("user") String user, @RequestParam("password") String password) {
        if (utenteGeneralDao.insert(new Utente(nome, cogn, user, password)))
            return "OK!";
        return "Errore nell'inserimento!";
    }


    @GetMapping(path = "/selectAll",
            produces = "text/plain")
    public String selectAll() {
        List<Utente> listUtente = utenteGeneralDao.selectAll();
        if (!listUtente.isEmpty()) {
            String retString = "Lista utenti:\n\n";
            for (Utente u : listUtente) {
                retString += "- " + u.getNome() + " " + u.getCognome() + "\n";
            }
            return retString;
        }
        return "Tabella utente vuota!";
    }

    @RequestMapping(path = "/selectByUser/{user}",
            method = RequestMethod.GET)
    public String selectByUser(@PathVariable("user") String user) {
        Utente utente = utenteDao.selectByUser(user);
        if (utente != null)
            return "SelectByUser:\n" + "- " + utente.getNome() + ", " + utente.getCognome() + ", " + utente.getUser() + ", " + utente.getPassword() + "!";
        return "Utente con user = '"+user+"' inserito inesistente!";
    }
}
