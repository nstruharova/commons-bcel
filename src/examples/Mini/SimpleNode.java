/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
/* Generated By:JJTree: Do not edit this line. SimpleNode.java */
/* JJT: 0.3pre1 */

package Mini;

/**
 */
public abstract class SimpleNode implements Node {
    protected Node parent;
    protected Node[] children;
    protected int id;
    protected MiniParser parser;

    public SimpleNode(final int i) {
        id = i;
    }

    public SimpleNode(final MiniParser p, final int i) {
        this(i);
        parser = p;
    }

    public void closeNode() {
    }

    public void dump(final String prefix) {
        System.out.println(toString(prefix));
        if (children != null) {
            for (final Node element : children) {
                final SimpleNode n = (SimpleNode) element;
                if (n != null) {
                    n.dump(prefix + " ");
                }
            }
        }
    }

    @Override
    public void jjtAddChild(final Node n, final int i) {
        if (children == null) {
            children = new Node[i + 1];
        } else if (i >= children.length) {
            final Node c[] = new Node[i + 1];
            System.arraycopy(children, 0, c, 0, children.length);
            children = c;
        }
        children[i] = n;
    }

    @Override
    public void jjtClose() {
    }

    @Override
    public Node jjtGetChild(final int i) {
        return children[i];
    }

    @Override
    public int jjtGetNumChildren() {
        return children == null ? 0 : children.length;
    }

    @Override
    public Node jjtGetParent() {
        return parent;
    }

    @Override
    public void jjtOpen() {
    }

    /*
     * You can override these two methods in subclasses of SimpleNode to customize the way the node appears when the tree is
     * dumped. If your output uses more than one line you should override toString(String), otherwise overriding toString()
     * is probably all you need to do.
     */

    @Override
    public void jjtSetParent(final Node n) {
        parent = n;
    }

    @Override
    public String toString() {
        return MiniParserTreeConstants.jjtNodeName[id];
    }

    /*
     * Override this method if you want to customize how the node dumps out its children.
     */

    public String toString(final String prefix) {
        return prefix + toString();
    }
}
