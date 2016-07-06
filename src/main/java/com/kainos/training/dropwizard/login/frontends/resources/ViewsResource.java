package com.kainos.training.dropwizard.login.frontends.resources;

import com.kainos.training.dropwizard.login.frontends.views.*;
import com.kainos.training.jersey.client.LoginClient;
import io.dropwizard.views.View;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

@Path("/test")
public class ViewsResource {

	LoginClient client;



	public ViewsResource(LoginClient client) {
		this.client = client;
	}

	@GET
	@Timed
	@Path("/login")
	@Produces(MediaType.TEXT_HTML)	
	public View login() {
		//code goes here.....

		return new Index();
	}
	
	@POST
	@Timed
	@Path("login-details")
	@Produces(MediaType.TEXT_HTML)
	public View loginDetails(@FormParam("username") String username,
			 			     @FormParam("password") String password){
		//Code goes here....


		if(client.getLogin(username, password)) {
			return new LoginSuccessView();
		} else {
			return new LoginFailureView();
		}
	}

	@POST
	@Timed
	@Path("register-details")
	@Produces(MediaType.TEXT_HTML)
	public View register(){
		//Code goes here....
		return new EnterRegistrationDetailsView();

	}

	@POST
	@Timed
	@Path("register-result")
	@Produces(MediaType.TEXT_HTML)
	public View registerDetails(@FormParam("username") String username,
						 @FormParam("password") String password) {



		if(client.register(username, password)) {
			return new RegisterSuccessView();
		} else {
			return new RegisterFailedView();
		}

	}

	@POST
	@Timed
	@Path("changepassword-details")
	@Produces(MediaType.TEXT_HTML)
	public View changePassword() {

		return new ChangePasswordDetailsView();

	}

	@POST
	@Timed
	@Path("changepassword-result")
	@Produces(MediaType.TEXT_HTML)
	public View changePasswordDetails(@FormParam("username") String username,
									  @FormParam("password") String password,
									  @FormParam("newPassword") String newPassword) {

		if(client.changePassword(username, password, newPassword)) {
			return new ChangePasswordSuccessView();
		} else {
			return new ChangePasswordFailedView();
		}
	}

}
