import processing.core.PApplet;

public class Sketch extends PApplet {

  int CELL_WIDTH = 20;
  int CELL_HEIGHT = 20;
  int MARGIN = 5;

  int ROW_COUNT = 10;
  int COLUMN_COUNT = 10;

  int SCREEN_WIDTH = (CELL_WIDTH + MARGIN) * COLUMN_COUNT + MARGIN;
  int SCREEN_HEIGHT = (CELL_HEIGHT + MARGIN) * ROW_COUNT + MARGIN;

  int intGrid[][] = new int[ROW_COUNT][COLUMN_COUNT];

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(SCREEN_WIDTH, SCREEN_HEIGHT);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0,0,0);

  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    for (int column = 0; column < COLUMN_COUNT; column++) {
      for (int row = 0; row < ROW_COUNT; row++) {

        // colour change
        if (intGrid[row][column] == 1) {

          fill(0, 255, 0);
          rect(MARGIN + (column * (CELL_WIDTH + MARGIN)), MARGIN + (row * (CELL_HEIGHT + MARGIN)), CELL_WIDTH, CELL_HEIGHT);
          
        }

        else {

          fill(255, 255, 255);
          rect(MARGIN + (column * (CELL_WIDTH + MARGIN)), MARGIN + (row * (CELL_HEIGHT + MARGIN)), CELL_WIDTH, CELL_HEIGHT);
        }


      }
    }
  }


  public void mousePressed() {

    // changes colour of cell clicked, and all surrounding cells
    for (int column = 0; column < COLUMN_COUNT; column++) {
      for (int row = 0; row < ROW_COUNT; row++) {

        // calculation of mouse coordinates is calculated by flooring the coordinates of mouseX and mouseY when divided by size of a cell
        if (mouseX / (CELL_WIDTH + MARGIN) == column && mouseY / (CELL_HEIGHT + MARGIN) == row) {

          // conditions that change colour of cell above cell pressed
          if (row > 0 && intGrid[row-1][column] == 0) {

            intGrid[row-1][column] = 1;
            
          }
          
          else if (row > 0 && intGrid[row-1][column] == 1) {

            intGrid[row-1][column] = 0;
            
          }

          // conditions that change color of cell below cell pressed
          if (row < ROW_COUNT - 1 && intGrid[row+1][column] == 0) {

            intGrid[row+1][column] = 1;
            
          }

          else if (row < ROW_COUNT - 1 && intGrid[row+1][column] == 1) {

            intGrid[row+1][column] = 0;
            
            
          }

          // conditions that change color of cell to the left of cell pressed
          if (column > 0 && intGrid[row][column-1] == 0) {

            intGrid[row][column-1] = 1;
            
          }

          else if (column > 0 && intGrid[row][column-1] == 1) {
          
            intGrid[row][column-1] = 0;
            
          }

          // conditions that change color of cell to the right of cell pressed
          if (column < COLUMN_COUNT - 1 && intGrid[row][column+1] == 0) {

            intGrid[row][column+1] = 1;
            
          }

          else if (column < COLUMN_COUNT - 1 && intGrid[row][column+1] == 1) {

            intGrid[row][column+1] = 0;
            
          }
          
          // conditions that change color of cell pressed
          if (intGrid[row][column] == 0) {

            intGrid[row][column] = 1;
            
          }

          else if (intGrid[row][column] == 1) {

            intGrid[row][column] = 0;
            
          }
          
        }
      }
    }
  }
}