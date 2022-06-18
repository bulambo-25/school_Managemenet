package za.ac.cput.repository.Interface;
/*
 * Name: Taariq Khan
 * Student number: 219231141
 * ADP372S – APPLICATIONS DEVELOPMENT PRACTICE 3
 * EXAMINER: K NAIDOO
 * MODERATOR: R BURGER
 * RELEASE DATE: 09th June 2022
 * DUE DATE: 18th June 2022
 * TOTAL MARKS: 100
 * */
import java.util.Optional;

public interface IRepository<T,ID>
{
    T save(T t);
    Optional<T>read(ID id);
    void delete(T t);
}
