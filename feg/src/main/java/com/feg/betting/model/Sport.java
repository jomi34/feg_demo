package com.feg.betting.model;

import java.util.stream.Stream;

public enum Sport {
	FOOTBALL(1), BASKETBALL(2), HANDBALL(3), VOLEYBALL(4),
	WATERPOLO(5), ICE_HOCKEY(6), TENNIS(7), FUTSAL(8);
	
	private int code;
	 
    private Sport(int code) {
        this.code = code;
    }
 
    public int getCode() {
        return code;
    }
    
    public static Sport valueOf(int code) {
    	 return Stream.of(Sport.values())
    	          .filter(c -> c.getCode() == code)
    	          .findFirst()
    	          .orElseThrow(IllegalArgumentException::new);
    }
    
   
}
