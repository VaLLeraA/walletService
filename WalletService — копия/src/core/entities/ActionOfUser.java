package entities;

public class ActionOfUser {

    private String nameOfAction;

    public ActionOfUser(String nameOfAction) {
        this.nameOfAction = nameOfAction;
    }

    public String getNameOfAction() {
        return nameOfAction;
    }

    public void setNameOfAction(String nameOfAction) {
        this.nameOfAction = nameOfAction;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ActionOfUser {");
        sb.append("nameOfAction='").append(nameOfAction).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
