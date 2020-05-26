package collection;

import java.util.ArrayList;
import java.util.List;

import charactor.Hero;

public class HeroNode {
        public Hero hero;
        //public float x;
        Object herovalue;
        public HeroNode leftNode;
        public HeroNode rightNode;
        //public HeroNode(float x){hero.hp = x;}

        public static void main(String[] args) {
            Hero[] heros = new Hero[10];
            HeroNode roots = new HeroNode();
            for(int i=0; i<10; i++){
                heros[i] = new Hero("hero" + i);
                heros[i].hp = (float)Math.random()*100;
            }
            for(Hero h : heros){
                roots.add(h);
                System.out.println(h);
            }
            /*System.out.println("herovalue的值: " + roots.herovalue);
            System.out.print(roots.leftNode.herovalue() + " ");
            System.out.println();
            System.out.print(roots.rightNode.herovalue() + " ");
            System.out.println();
            System.out.println(roots.herovalue());*/
            System.out.println("根据血量倒排序后的Hero");
            List<Object> treeSortedHeros = roots.herovalue();
            System.out.println(treeSortedHeros);
        }

        public void add(Hero heros){
            if(null == hero){
                hero = heros;
            }else{
                if(hero.hp > heros.hp){
                    if(null == leftNode){
                        leftNode = new HeroNode();
                    }
                    leftNode.add(heros);
                }else{
                    if(null == rightNode){
                        rightNode = new HeroNode();
                    }
                    rightNode.add(heros);
                }
            }
        }

        //后序遍历所有节点
        public List<Object> herovalue(){
            List<Object> herovalue = new ArrayList<>();

            if(null != leftNode)
                herovalue.addAll(leftNode.herovalue());
            
            if(null != rightNode){
                herovalue.addAll(rightNode.herovalue());
            }
            herovalue.add(hero);

            return herovalue;
        }
}


    