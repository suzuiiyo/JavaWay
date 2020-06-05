package generic;

import java.util.ArrayList;
import java.util.List;

import charactor.Hero;
import collection.Node;

public class GenericTNode<T extends Comparable<T>> {
    public T value;
    public GenericTNode<T> leftNode;
    public GenericTNode<T> rightNode;

    public void add(T t){
        if(value == null)
            value = t;
        else{
            if(t.compareTo(value) < 0){
                if(leftNode == null)
                    leftNode = new GenericTNode<T>();
                leftNode.add(t);
            }
            else if(t.compareTo(value) > 0) {
                if(rightNode == null)
                    rightNode = new GenericTNode<T>();
                rightNode.add(t);
            }
        }
    }

        //µÝ¹é·¨ÖÐÐò±éÀú
    public List<T> iterate(){
        List<T> nodeList = new ArrayList<>();
        if(null != leftNode)
            nodeList.addAll(leftNode.iterate());
        
        nodeList.add(value);

        if(null != rightNode)
            nodeList.addAll(rightNode.iterate());
        
        return nodeList;
    }

    public static void main(String[] args) {
        int randoms[] = new int[] {67, 7, 30, 72, 10, 0, 78, 81, 10, 74};
        Node roots = new Node();
        for(int n : randoms){
            roots.add(n);
        }
        System.out.println(roots.values());

        List<Hero> herolist = new ArrayList<>();
        for(int i =0; i<10; i++){
            herolist.add(new Hero("hero" + i));
        }
        GenericTNode<Hero> heroTree = new GenericTNode<>();
        for(Hero h : herolist){
            heroTree.add(h);
        }
        System.out.println(heroTree.iterate());
    }
}