public class CommandPlaceDomino implements CommandInterface {

    private Aardvark aardvark;
    private int x13, y13;

    public CommandPlaceDomino(Aardvark aardvark){
        this.aardvark = aardvark;
    }

    @Override
    public void playGame() {
        int x = AardvarkSecond.gecko(99);
        while (x < 1 || x > 8) {
            try {
                String s3 = IOLibrary.getString();
                x = Integer.parseInt(s3);
            } catch (Exception e) {
                System.out.println("Bad input");
                x = AardvarkSecond.gecko(65);
            }
        }
        System.out.println("Row?");
        int y = AardvarkSecond.gecko(98);
        while (y < 1 || y > 7) {
            try {
                String s3 = IOLibrary.getString();
                y = Integer.parseInt(s3);
            } catch (Exception e) {
                System.out.println("Bad input");
                y = AardvarkSecond.gecko(64);
            }
        }
        x--;
        y--;
        System.out.println("Horizontal or Vertical (H or V)?");
        int y2, x2;
        Location location;
        while (true) {
            String s3 = IOLibrary.getString();
            if (s3 != null && s3.toUpperCase().startsWith("H")) {
                location = new Location(x, y, Location.DIRECTION.HORIZONTAL);
                System.out.println("Direction to place " + location.direction);
                x2 = x + 1;
                y2 = y;
                break;
            }
            if (s3 != null && s3.toUpperCase().startsWith("V")) {
                location = new Location(x, y, Location.DIRECTION.VERTICAL);
                System.out.println("Direction to place is " + location.direction);
                x2 = x;
                y2 = y + 1;
                break
            }
            System.out.println("Enter H or V");
        }
        if (x2 > 7 || y2 > 6) {
            System.out.println("Problems placing the domino with that position and direction");
        } else {

            Domino d = aardvark.as.findByLH(aardvark, aardvark.grid[y][x], aardvark.grid[y2][x2], aardvark._g);
            if (d == null) {
                System.out.println("There is no such domino");
            }

            if (d.placed) {
                System.out.println("That domino has already been placed :");
                System.out.println(d);
            }

            if (aardvark.gg[y][x] != 9 || aardvark.gg[y2][x2] != 9) {
                System.out.println("Those coordinates are not vacant");
            }

            aardvark.gg[y][x] = aardvark.grid[y][x];
            aardvark.gg[y2][x2] = aardvark.grid[y2][x2];
            if (aardvark.grid[y][x] == d.high && aardvark.grid[y2][x2] == d.low) {
                d.place(x, y, x2, y2);
            } else {
                d.place(x2, y2, x, y);
            }
            aardvark.score +=1000;
            aardvark.as.collateGuessGrid(aardvark);
            aardvark.pf.dp.repaint();
        }
    }

    @Override
    public void undoGame() {
        x13--;
        y13--;
        Domino placedDomino = aardvark.as.findAt(aardvark, x13, y13, aardvark._g);
        if(placedDomino == null){
            System.out.println("No domino found at the specific place");
        } else {
            placedDomino.placed = false;
            aardvark.gg[placedDomino.hy][placedDomino.hx] = 9;
            aardvark.gg[placedDomino.ly][placedDomino.lx] = 9;
            aardvark.score -= 1000;
            aardvark.as.collateGuessGrid(aardvark);
            aardvark.pf.dp.repaint();
            System.out.println("Command Undone...");
        }
    }
}



