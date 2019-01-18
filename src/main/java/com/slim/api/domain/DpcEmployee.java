/**
 * 
 */
package com.slim.api.domain;

import java.util.Collection;
import java.util.Date;




import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author slim
 *
 */

@JacksonXmlRootElement(localName = "DpcEmployee")

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DpcEmployee {

	    @JacksonXmlProperty(isAttribute = true)
	    private Long id;
	 @JacksonXmlProperty    
	    private String nom;
	 @JacksonXmlProperty    
	    private String prenom;
	 
	 
	 

}
