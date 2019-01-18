package com.slim.api.domain;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JacksonXmlRootElement(localName = "List")

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserData {
	DpcEmployee[] data;
}
