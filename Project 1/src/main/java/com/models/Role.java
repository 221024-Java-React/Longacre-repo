package com.models;

import io.javalin.security.RouteRole;

public enum Role implements RouteRole {
	MANAGER, EMPLOYEE, ; 
}
