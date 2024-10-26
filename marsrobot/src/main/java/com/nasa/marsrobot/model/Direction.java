package com.nasa.marsrobot.model;

public enum  Direction {
    NORTH("N", 0, 1), 
	EAST("E", 1, 0), 
	SOUTH("S", 0, -1), 
	WEST("W", -1, 0);
    
	private final String abbreviation;
    private final int xChange;
    private final int yChange;

    Direction(String abbreviation, int xChange, int yChange) {
        this.abbreviation = abbreviation;
        this.xChange = xChange;
        this.yChange = yChange;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public int getXChange() {
        return xChange;
    }

    public int getYChange() {
        return yChange;
    }

    public Direction getLeft() {
        switch (this) {
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
            default:
                return SOUTH;
        }
    }

    public Direction getRight() {
        switch (this) {
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            case EAST:
                return SOUTH;
            default:
                return NORTH;
        }
    }
}
