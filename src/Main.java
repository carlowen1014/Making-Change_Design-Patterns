// Carl Owen
// Design Pattern Lab
// Mon. 18 Nov. 2024
// Adding design methods and implementations to the Making Change Lab

public static void main(String[] args) {
    DenominationFactory factory = new USDDenominationFactory();
    Register register = new Register(factory);

    JFrame frame = new JFrame("Making Change");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);

    RegisterPanel panel = new RegisterPanel(register);
    frame.add(panel);

    frame.setVisible(true);
}