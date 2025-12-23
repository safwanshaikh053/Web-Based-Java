package example.jdbc;

import java.util.Collection;

public interface DaoInterface<T, ID> {
	Collection<T> getAll();            // no criteria fetches all whole table therefore no parameters
	T getOne(ID id);            // one criteria to fetch that one specific row/record.
	void create(T t);          // we do not expect any return value therefore void return type.
	void update(T t);
	void deleteOne(ID id);
}
