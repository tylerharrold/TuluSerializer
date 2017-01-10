package serializer.datastructures;

public class TNode {
	private TContainer item;
	private TNode next;
	
	public TNode(TContainer obj){
		this.item = obj;
		this.next = null;
	}
	
	public TNode(TContainer obj, TNode next){
		this.item = obj;
		this.next = next;
	}
	
	public void setObj(TContainer obj){
		this.item = obj;
	}
	
	public void setNext(TNode next){
		this.next = next;
	}
	
	public TContainer getItem(){
		return item;
	}
	
	public TNode getNext(){
		return next;
	}
}
