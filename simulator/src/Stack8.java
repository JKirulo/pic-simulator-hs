import java.util.Stack;
/**
 * 
 * @author https://stackoverflow.com/users/1348839/calvin
 *
 * @param <T>
 */
public class Stack8<T> extends Stack<T> {
	private int maxSize;

    public Stack8(int size) {
        super();
        this.maxSize = size;
    }

    @Override
    public T push(T object) {
        //If the stack is too big, remove elements until it's the right size.
        while (this.size() >= maxSize) {
            this.remove(0);
        }
        return super.push(object);
    }
}