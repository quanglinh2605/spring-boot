package com.demo.models;

import java.util.ArrayList;
import java.util.List;

import com.demo.entities.Certificate;

public class CertificateModel {
	public List<Certificate> findall(){
		List<Certificate> certificates = new ArrayList<Certificate>();
		certificates.add(new Certificate("c1","Certificate 1"));
		certificates.add(new Certificate("c2","Certificate 2"));
		certificates.add(new Certificate("c3","Certificate 3"));
		certificates.add(new Certificate("c4","Certificate 4"));
		certificates.add(new Certificate("c5","Certificate 5"));
		certificates.add(new Certificate("c6","Certificate 6"));
		return certificates;
	}
}
