package skribbl_backend.Dto;



import lombok.Data;

@Data
public class DrawData {

    private double x;

    private double y;

    private String type;
    private String color;

    private int brushSize;
}