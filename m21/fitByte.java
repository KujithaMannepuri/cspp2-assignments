import java.util.Scanner;
class FoodLog {
	private String foodItem;
	private Double quantity;
	private String date;

	FoodLog(String foodItem1, Double quantity1, String date1) {
		this.foodItem = foodItem1;
		this.quantity = quantity1;
		this.date = date1;
	}

	public String getFood() {
		return foodItem;
	}

	public Double getQuantity() {
		return quantity;
	}

	public String getDate() {
		return date;
	}
}

class WaterLog {
	private Double wquantity;

	WaterLog(Double wquan1) {
		this.wquantity = wquan1;
	}

	public Double getQuantity() {
		return wquantity;
	}
}

class PhyActivities {
	private String name;
	private String date;
	private String stime;
	private String etime;
	private String notes;

	PhyActivities(String name1, String date1, String st, String et, String notes1) {
		this.name = name1;
		this.date = date1;
		this.stime = st;
		this.etime = et;
		this.notes = notes1;
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public String getStartTime() {
		return stime;
	}
	public String getEndTime() {
		return etime;
	}
	public String getNotes() {
		return notes;
	}
}

class Weight {
	private Double weight;
	private double fat;
	private String date;

	Weight(double wght, double fat1, String date1) {
		this.weight = wght;
		this.fat = fat1;
		this.date = date1;
	}

	public double getWeight() {
		return weight;
	}
	public double getFat() {
		return fat;
	}
	public String getDate() {
		return date;
	}
}

class Sleep {
	private String strtTime;
	private String endTime;

	Sleep(String stime, String etime) {
		this.strtTime = stime;
		this.endTime = etime;
	}
	public String getStrtTime() {
		return strtTime;
	}
	public String getEndTime() {
		return endTime;
	}
}

class Summary {
	private FoodLog[] food;
	private WaterLog[] water;
	private PhyActivities[] phact;
	private Weight[] wght;
	private Sleep[] sleep;
	private int size1, size2, size3, size4, size5;

	Summary() {
		final int t = 10;
		food = new FoodLog[t];
        water = new WaterLog[t];
        phact = new PhyActivities[t];
        wght = new Weight[t];
        sleep = new Sleep[t];
        size1 = 0;
        size2 = 0;
        size3 = 0;
        size4 = 0;
        size5 = 0;
	}
	public void addFood(String item, double quan, String date) {
		FoodLog food1 = new FoodLog(item, quan, date);
		food[size1++] = food1;
	}
	public void addWater(double wquan) {
		WaterLog water1 = new WaterLog(wquan);
		water[size2++] = water1;
	}
	public void addPhact(String name, String date, String st, String et, String notes) {
		PhyActivities phact1 = new PhyActivities(name, date, st, et, notes);
		phact[size3++] = phact1;
	}
	public void addWeight(double wghtt, double fat, String date) {
		Weight wght1 = new Weight(wghtt, fat, date);
		wght[size4++] = wght1;
	}
	public void addSleep(String stime, String etime) {
		Sleep slp = new Sleep(stime, etime);
		sleep[size5++] = slp; 
	}
	public void show() {
		for (int i = 0; i < size1; i++) {
            System.out.println(food[i].getFood() + "\n" + food[i].getQuantity() + "\n" + food[i].getDate());
        }

        for (int i = 0; i < size2; i++) {
            System.out.println(water[i].getQuantity());
        }

        for (int i = 0; i < size3; i++) {
            System.out.println(phact[i].getName() + "\n" + phact[i].getDate() + "\n" + phact[i].getStartTime() + "\n" + phact[i].getEndTime() + "\n" + phact[i].getNotes());            
        }

        for (int i = 0; i < size4; i++) {
            System.out.println(wght[i].getWeight() + "\n" + wght[i].getFat() + "\n" + wght[i].getDate());
        }

        for (int i = 0; i < size5; i++) {
            System.out.println(sleep[i].getStrtTime() + "\n" + sleep[i].getEndTime());
        }
    }
	}

class fitByte {
	public static void main(String[] args) {
        Summary sum = new Summary();
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            String line = s.nextLine();
            String[] tokens = line.split(" ", 2);
            switch(tokens[0]) {
                case "Food":
                String[] tokens1 = tokens[1].split(",");
                sum.addFood(tokens1[0], Double.parseDouble(tokens1[1]), tokens1[2]);
                break;
                case "Water":
                sum.addWater(Double.parseDouble(tokens[1]));
                break;
                case "PhysicalActivity":
                String[] tokens2 = tokens[1].split(",");
                sum.addPhact(tokens2[0], tokens2[1], tokens2[2], tokens2[3], tokens2[4]);
                break;
                case "Weight":
                String[] tokens3 = tokens[1].split(",");
                sum.addWeight(Double.parseDouble(tokens3[0]), Double.parseDouble(tokens3[1]), tokens3[2]);
                break;
                case "Sleep":
                String[] tokens4 = tokens[1].split(",");
                sum.addSleep(tokens4[0], tokens4[1]);
                break;
                case "Summary":
                sum.show();
                default:
                break;
            }
        }

    }
}

