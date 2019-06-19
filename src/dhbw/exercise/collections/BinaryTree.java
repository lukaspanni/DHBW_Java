package dhbw.exercise.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BinaryTree<T extends Comparable<T>> {

	private T value;

	private BinaryTree<T> left;
	private BinaryTree<T> right;

	public boolean add(T value) {
		if (this.value == null) {
			this.value = value;
			return true;
		}
		if (value.compareTo(this.value) < 0) {
			if (this.left == null) {
				this.left = new BinaryTree<T>();
			}
			return this.left.add(value);
		} else if (value.compareTo(this.value) > 0) {
			if (this.right == null) {
				this.right = new BinaryTree<T>();
			}
			return this.right.add(value);
		} else {
			return false;
		}

	}

	public T getValue() {
		return this.value;
	}

	public List<T> traverse() {
		List<T> list = new LinkedList<T>();
		if (this.left != null) {
			list.addAll(this.left.traverse());
		}
		if (this.value != null) {
			list.add(this.value);
		}
		if (this.right != null) {
			list.addAll(this.right.traverse());
		}
		return list;
	}

	public List<T> betterTraverse() {
		List<T> list = new LinkedList<T>();
		doTraverse(list);
		return list;
	}

	private void doTraverse(List<T> list) {
		if (this.left != null) {
			this.left.doTraverse(list);
		}
		if (this.value != null) {
			list.add(this.value);
		}
		if (this.right != null) {
			this.right.doTraverse(list);
		}
	}

	public static void main(String[] args) {
		BinaryTree<Integer> binTree = new BinaryTree<Integer>();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			int random = r.nextInt(42);
			System.out.print(random);
			if (binTree.add(random)) {
				System.out.println(" hinzugefügt");
			} else {
				System.out.println(" nicht hinzugefügt - bereits im Baum");
			}
		}
		List<Integer> traversed = binTree.traverse();
		System.out.println(traversed.toString());

	}

}
