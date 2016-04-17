package models.indoormapping;

import tools.Point;
import tools.RectangleDB;
import tools.Rectangle;

import java.io.Serializable;

public class Room implements Serializable{
    private String roomName;
    private String id;
    private String building_id;
    private Rectangle roomRectangle;
    private RectangleDB rectangleDB;
    private String roomDescription;
    private double width,height;
    private double est_time;
    private int excitement;


    public Room(String id, String building_id, String roomName, RectangleDB rectangleDB, double width, double height, double est_time, int excitement){
        this.roomName = roomName;
        this.id = id;
        this.width = width;
        this.height = height;
        //this.roomDescription = roomDescription;
        this.rectangleDB = rectangleDB;
        this.building_id = building_id;
        this.roomRectangle = new Rectangle(new Point(0,0),0,0); //for testing!!!
        this.est_time = est_time;
        this.excitement = excitement;
    }

    public String getBuilding_id() {
        return building_id;
    }

    public Room(String building_id, String roomName, RectangleDB rectangleDB, double width, double height){
        this.building_id = building_id;

        this.roomName = roomName;
        this.width = width;
        this.height = height;
        this.roomDescription = "";
        this.rectangleDB = rectangleDB;
        this.roomRectangle = new Rectangle(new Point(0,0),0,0); //for testing!!!
    }

    public Room(Rectangle r){
        this.roomRectangle = r;
        roomName = "";
        roomDescription = "";
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Rectangle getRoomRectangle() {
        return roomRectangle;
    }

    public void setRoomRectangle(Rectangle roomRectangle) {
        this.roomRectangle = roomRectangle;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public boolean isNeighbour(Room room){
        //for convenience, a room is not its own neighbour
        if(this == room)
            return false;

        if(this.getRoomRectangle().getCoordinates().getX() + this.getRoomRectangle().getWidth()
                == room.getRoomRectangle().getCoordinates().getX()
                || this.getRoomRectangle().getCoordinates().getY() + this.getRoomRectangle().getHeight()
                == room.getRoomRectangle().getCoordinates().getY()
                || room.getRoomRectangle().getCoordinates().getX() + room.getRoomRectangle().getWidth()
                == this.getRoomRectangle().getCoordinates().getX()
                || room.getRoomRectangle().getCoordinates().getY() + room.getRoomRectangle().getHeight()
                == this.getRoomRectangle().getCoordinates().getY())
            return true;

        return false;

    }

    public String getId() {
        return id;
    }

    public RectangleDB getRectangleDB() {
        return rectangleDB;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setEst_time(double est_time) {
        this.est_time = est_time;
    }

    public int getExcitement(){return excitement; }

    public double getEst_time() {

        return est_time;
    }

}