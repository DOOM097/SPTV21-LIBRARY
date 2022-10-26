
package Entity;


public class Author {
    private String firstname;
    private String lastname;
    private int birthday;

    public Author() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Author{" 
                + "firstname=" + firstname 
                + ", lastname=" + lastname 
                + ", birthday=" + birthday 
                + '}';
    }
    

}