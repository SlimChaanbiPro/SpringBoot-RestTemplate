package com.slim.services;

import java.util.List;

import com.slim.api.domain.Utilisateur;

public interface ApiService
{

    List<Utilisateur> getUtilisateurs(Integer limit);
}
