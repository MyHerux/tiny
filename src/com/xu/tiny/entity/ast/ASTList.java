package com.xu.tiny.entity.ast;

import java.util.Iterator;
import java.util.List;

/**
 * Created by xu on 2017/6/1.
 * 非叶节点，可能包含多个子节点
 */
public class ASTList extends ASTree {

    //子节点集合
    protected List<ASTree> children;

    public ASTList(List<ASTree> lis) {
        children = lis;
    }

    @Override
    public ASTree child(int i) {
        return children.get(i);
    }

    @Override
    public int numChildren() {
        return children.size();
    }

    @Override
    public Iterator<ASTree> children() {
        return children.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        String seq = "";
        for (ASTree t : children) {
            sb.append(seq);
            seq = " ";
            sb.append(t.toString());
        }
        return sb.append(')').toString();
    }

    @Override
    public String location() {
        for (ASTree t : children) {
            String s = t.location();
            if (s != null) {
                return s;
            }
        }
        return null;
    }
}
