//class and object
class Vehicle {
    String company;
    String type;
    double cost;

    Vehicle(String company, String type, double cost) {
        this.company = company;
        this.type = type;
        this.cost = cost;
    }

    void showInfo() {
        System.out.println("Company: " + company + ", Type: " + type + ", Cost: $" + cost);
    }
}
void main(String[] args) {
        Vehicle v1 = new Vehicle("Toyota", "Corolla", 28000);
        Vehicle v2 = new Vehicle("Honda", "Civic", 31000);

        v1.showInfo();
        v2.showInfo();
    }


