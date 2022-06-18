package za.ac.cput.repository.Interface;
/*
 * name: Taariq Khan
 * student number: 219231141
 *
 *
 *
 *
 * */
import java.util.Optional;

public interface IRepository<T,ID>
{
    T save(T t);
    Optional<T>read(ID id);
    void delete(T t);
}
