package repository.base;

public interface GenericRepository <T,ID>{
    T add(T t);
    T update(T t);
    void delete(T t);
    T findById(Class <T> tClazz,ID id);
}
