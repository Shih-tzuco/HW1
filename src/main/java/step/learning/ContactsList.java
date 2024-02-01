package step.learning;

public class ContactsList {
    private final String name;
    private final String surname;
    private final String fathername;
    private final Integer number;
    public ContactsList(String name, String surname, String fathername, Integer number)
    {
        this.name = name;
        this.surname = surname;
        this.fathername = fathername;
        this.number = number;
    }
    public String getName()
    {
        return name;
    }
    public String getSurname()
    {
        return surname;
    }
    public String getFathername()
    {
        return fathername;
    }

    public Integer getNumber()
    {
        return number;
    } //  I am not sure that Integer was a good idea, maybe better choose String
    public String getContactsList()
    {
        return String.format("Surname: '%s'. Name: '%s'. Fathername '%s'. Phone number: '%s'",
                this.getSurname(), this.getName(), this.getFathername(), this.getNumber());
    }
}
