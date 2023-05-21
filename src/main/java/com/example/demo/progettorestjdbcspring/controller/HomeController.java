package com.example.demo.progettorestjdbcspring.controller;

import com.example.demo.progettorestjdbcspring.db.dao.interfaces.GeneralDaoInterface;
import com.example.demo.progettorestjdbcspring.db.dao.model.Prodotto;
import com.example.demo.progettorestjdbcspring.db.dao.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    @Qualifier("prodottoGeneralDaoInterface")
    private GeneralDaoInterface<Prodotto> generalProdottoDao;

    @Autowired
    @Qualifier("utenteGeneralDaoInterface")
    private GeneralDaoInterface<Utente> utenteGeneralDao;

    @RequestMapping(
            path = "/getHome/{userId}",
            method = {RequestMethod.GET, RequestMethod.POST}
            )
    public String getHome(@PathVariable("userId") int userId, Model model) {
        Utente utente =utenteGeneralDao.selectById(userId);
        List<Prodotto> prodottoList= generalProdottoDao.selectAll();
        if(utente!=null && prodottoList!=null){
            model.addAttribute("nomeUtente",utente.getNome());
            model.addAttribute("cognomeUtente",utente.getNome());
            model.addAttribute("prodottoList",prodottoList);
            return "index";
        }
        return "Errore,pagina non disponibile!";
    }
}
