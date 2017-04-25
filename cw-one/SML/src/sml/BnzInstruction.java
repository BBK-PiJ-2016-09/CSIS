package sml;

public class BnzInstruction extends Instruction {
    private int register;
    private String label2Go2;
    private int value;
    public BnzInstruction(String label, String opcode) {
        super(label, opcode);
    }

    public BnzInstruction(String label, int register, String label2Go2) {
        super(label, "bnz");
        this.register = register;
        this.label2Go2 = label2Go2;
    }

    @Override
    public void execute(Machine m) {
        this.value = m.getRegisters().getRegister(register);
        if(value != 0) {

            m.setPc(m.getLabels().indexOf(this.label2Go2));
        }
    }

    @Override
    public String toString() {
        return super.toString() + " register " + register + " value is " + this.value;
    }
}
