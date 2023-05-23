package Lection6;

import java.util.Date;
import java.util.Objects;

public class Worker {
    int id;
    int salary;
    String firstname;
    String lastname;
//    String secondName;
//    Date birthDate;
//    String Position;


    @Override
    public String toString() {
        return "Worker1{" +
                "id=" + id +
                ", salary=" + salary +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Worker t = (Worker) o;
        return id == t.id && firstname == t.firstname;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
