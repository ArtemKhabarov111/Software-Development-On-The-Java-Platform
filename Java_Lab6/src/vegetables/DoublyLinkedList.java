package vegetables;

import java.util.*;

/**
 * Узагальнений двозв'язний список
 *
 * @param <T> тип елементів списку, який повинен наслідувати клас {@link Vegetables}.
 */
public class DoublyLinkedList<T extends Vegetables> implements List<T> {

    /** Головний елемент списку. */
    private Node head;

    /** Останній елемент списку. */
    private Node tail;

    /** Кількість елементів у списку. */
    private int size;

    /**
     * Клас, що представляє вузол списку.
     */
    private class Node {
        /** Дані вузла. */
        T data;

        /** Посилання на наступний вузол. */
        Node next;

        /** Посилання на попередній вузол. */
        Node prev;

        /**
         * Конструктор вузла.
         *
         * @param data елемент списку
         */
        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * Порожній конструктор.
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Конструктор, в який передається 1 об’єкт узагальненого класу.
     *
     * @param element елемент для додавання
     */
    public DoublyLinkedList(T element) {
        this();
        add(element);
    }

    /**
     * Конструктор, в який передається стандартна колекція об’єктів.
     *
     * @param collection колекція елементів для додавання
     */
    public DoublyLinkedList(Collection<? extends T> collection) {
        this();
        addAll(collection);
    }

    /**
     * Повертає кількість елементів у списку.
     *
     * @return кількість елементів
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Перевіряє, чи список порожній.
     *
     * @return true, якщо список порожній, інакше false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Перевіряє наявність елемента у списку.
     *
     * @param o об'єкт для перевірки
     * @return true, якщо елемент наявний, інакше false
     */
    @Override
    public boolean contains(Object o) {
        for (T item : this) {
            if (Objects.equals(item, o)) return true;
        }
        return false;
    }

    /**
     * Повертає ітератор для списку.
     *
     * @return ітератор елементів списку
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    /**
     * Повертає масив об'єктів з елементами списку.
     *
     * @return масив елементів списку
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

    /**
     * Повертає масив заданого типу з елементами списку.
     *
     * @param a масив, у який будуть скопійовані елементи
     * @param <T1> тип елементів масиву
     * @return масив елементів списку
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            a = (T1[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        int i = 0;
        Node current = head;
        while (current != null) {
            a[i++] = (T1) current.data;
            current = current.next;
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    /**
     * Додає елемент у кінець списку.
     *
     * @param element елемент для додавання
     * @return true, якщо елемент додано
     */
    @Override
    public boolean add(T element) {
        Node node = new Node(element);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
        return true;
    }

    /**
     * Видаляє перше входження елемента зі списку.
     *
     * @param o елемент для видалення
     * @return true, якщо елемент видалено
     */
    @Override
    public boolean remove(Object o) {
        Node current = head;
        while (current != null) {
            if (Objects.equals(current.data, o)) {
                unlink(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Перевіряє наявність усіх елементів колекції у списку.
     *
     * @param c колекція для перевірки
     * @return true, якщо всі елементи присутні
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) return false;
        }
        return true;
    }

    /**
     * Додає всі елементи з колекції у кінець списку.
     *
     * @param c колекція елементів для додавання
     * @return true, якщо колекція не порожня
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T e : c) add(e);
        return !c.isEmpty();
    }

    /**
     * Додає всі елементи з колекції на задану позицію списку.
     *
     * @param index позиція для вставки
     * @param c колекція елементів для додавання
     * @return true, якщо додано хоча б один елемент
     */
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Некоректний індекс: " + index);
        if (c.isEmpty()) return false;
        int i = index;
        for (T e : c) add(i++, e);
        return true;
    }

    /**
     * Видаляє всі елементи, що містяться у заданій колекції.
     *
     * @param c колекція елементів для видалення
     * @return true, якщо список змінено
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            if (c.contains(current.data)) {
                unlink(current);
                modified = true;
            }
            current = next;
        }
        return modified;
    }

    /**
     * Залишає у списку тільки ті елементи, що містяться у заданій колекції.
     *
     * @param c колекція елементів для збереження
     * @return true, якщо список змінено
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            if (!c.contains(current.data)) {
                unlink(current);
                modified = true;
            }
            current = next;
        }
        return modified;
    }

    /**
     * Очищає список.
     */
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /**
     * Повертає елемент за індексом.
     *
     * @param index позиція елемента
     * @return елемент списку
     */
    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    /**
     * Замінює елемент за індексом і повертає старе значення.
     *
     * @param index позиція елемента
     * @param element новий елемент
     * @return старий елемент
     */
    @Override
    public T set(int index, T element) {
        Node node = getNode(index);
        T oldValue = node.data;
        node.data = element;
        return oldValue;
    }

    /**
     * Додає елемент на задану позицію списку.
     *
     * @param index позиція для вставки
     * @param element елемент для додавання
     */
    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Некоректний індекс: " + index);

        Node node = new Node(element);
        if (index == size) {
            add(element);
            return;
        }
        if (index == 0) {
            node.next = head;
            if (head != null) head.prev = node;
            head = node;
            if (tail == null) tail = node;
        } else {
            Node current = getNode(index);
            Node prev = current.prev;
            prev.next = node;
            node.prev = prev;
            node.next = current;
            current.prev = node;
        }
        size++;
    }

    /**
     * Видаляє елемент за індексом.
     *
     * @param index позиція елемента
     * @return видалений елемент
     */
    @Override
    public T remove(int index) {
        Node node = getNode(index);
        T oldValue = node.data;
        unlink(node);
        return oldValue;
    }

    /**
     * Повертає індекс першого входження елемента.
     *
     * @param o елемент для пошуку
     * @return індекс або -1, якщо елемент не знайдено
     */
    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (Objects.equals(current.data, o)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    /**
     * Повертає індекс останнього входження елемента.
     *
     * @param o елемент для пошуку
     * @return індекс або -1, якщо елемент не знайдено
     */
    @Override
    public int lastIndexOf(Object o) {
        int index = size - 1;
        Node current = tail;
        while (current != null) {
            if (Objects.equals(current.data, o)) return index;
            current = current.prev;
            index--;
        }
        return -1;
    }

    /**
     * Повертає {@link ListIterator} починаючи з початку списку.
     *
     * @return ітератор списку
     */
    @Override
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    /**
     * Повертає {@link ListIterator} починаючи з заданого індексу.
     *
     * @param index позиція старту
     * @return ітератор списку
     */
    @Override
    public ListIterator<T> listIterator(int index) {
        return new ListIterator<T>() {
            Node current = (index == size) ? null : getNode(index);
            Node lastReturned = null;
            int nextIndex = index;

            @Override
            public boolean hasNext() {
                return nextIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                lastReturned = current;
                T data = current.data;
                current = current.next;
                nextIndex++;
                return data;
            }

            @Override
            public boolean hasPrevious() {
                return nextIndex > 0;
            }

            @Override
            public T previous() {
                if (!hasPrevious()) throw new NoSuchElementException();
                current = (current == null) ? tail : current.prev;
                lastReturned = current;
                nextIndex--;
                return current.data;
            }

            @Override
            public int nextIndex() {
                return nextIndex;
            }

            @Override
            public int previousIndex() {
                return nextIndex - 1;
            }

            @Override
            public void remove() {
                if (lastReturned == null) throw new IllegalStateException();
                unlink(lastReturned);
                lastReturned = null;
            }

            @Override
            public void set(T t) {
                if (lastReturned == null) throw new IllegalStateException();
                lastReturned.data = t;
            }

            @Override
            public void add(T t) {
                DoublyLinkedList.this.add(nextIndex++, t);
                lastReturned = null;
            }
        };
    }

    /**
     * Повертає підсписок із заданого діапазону індексів.
     *
     * @param fromIndex початковий індекс (включно)
     * @param toIndex кінцевий індекс (виключно)
     * @return підсписок
     */
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }

        DoublyLinkedList<T> sub = new DoublyLinkedList<>();
        Node current = getNode(fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            sub.add(current.data);
            current = current.next;
        }
        return sub;
    }

    /**
     * Метод для видалення вузла зі списку.
     *
     * @param node вузол для видалення
     */
    private void unlink(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        if (prev == null) head = next;
        else prev.next = next;

        if (next == null) tail = prev;
        else next.prev = prev;

        size--;
    }

    /**
     * Повертає вузол за індексом.
     *
     * @param index позиція вузла
     * @return вузол списку
     */
    private Node getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Некоректний індекс: " + index);
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }
}
