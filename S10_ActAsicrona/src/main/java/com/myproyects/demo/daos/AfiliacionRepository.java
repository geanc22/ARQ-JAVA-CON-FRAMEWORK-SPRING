package com.myproyects.demo.daos;



import org.springframework.data.mongodb.repository.MongoRepository;


import com.myproyects.demo.entidades.Afiliacion;


public interface AfiliacionRepository extends MongoRepository<Afiliacion,String> {

	
}
