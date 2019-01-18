package com.slim.api.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Utilisateur implements Serializable {
	
	 private final static long serialVersionUID = 5798633039064811438L;
	private    Long id ;
	private String  nom;
	private String prenom ;
	private String remarque ;
	private Date date_naissance ;
	private String sexe ;
	private String SituationFamiliale ;
	private String Photo ;
	private Long Cin ;
	private Boolean parain ;
	private Date lastPasswordResetDate;
	private String telephone;
	private String username;
	private String password;
	private String email ;
	private String num_passport ;
	private String profil;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
