class AVL {
    NodeAVL root;

    AVL() {
        root = null;
    }

    public void insert(Integer val) {
        root = insert(val, root);
    }

    private NodeAVL insert(Integer value, NodeAVL rt) {
        if (rt == null) {
            rt = new NodeAVL(value);
            return rt;
        } else {
            if (value > rt.val) {
                rt.rc = insert(value, rt.rc);
                if (Height(rt.rc) - Height(rt.lc) > 1) {
                    if (value > rt.rc.val) {
                        rt = LeftRotation(rt);
                    } else
                        rt = RightLeftRotation(rt);
                }
            } else {
                rt.lc = insert(value, rt.lc);
                if (Height(rt.lc) - Height(rt.rc) > 1) {
                    if (value < rt.lc.val) {
                        rt = RightRotation(rt);
                    } else
                        rt = LeftRightRotation(rt);
                }
            }
        }
        return rt;
    }

    public void Delete(Integer val) {
        root = Delete(val, root);
    }

    private NodeAVL Delete(Integer value, NodeAVL rt) {
        if (rt.val == value) {
            if (rt.rc == null && rt.lc == null)
                rt = null;
            else {
                if (rt.rc == null)
                    rt = rt.lc;
                else if (rt.lc == null)
                    rt = rt.rc;
                else {
                    NodeAVL temp = rt.lc;
                    while (temp.rc != null)
                        temp = temp.rc;
                    int x = temp.val;
                    Delete(temp.val);
                    rt.val = x;
                }
            }
        } else {
            if (value > rt.val) {
                rt.rc = Delete(value, rt.rc);
                if (Height(rt.rc) - Height(rt.lc) > 1) {
                    if (value > rt.rc.val) {
                        rt = LeftRotation(rt);
                    } else
                        rt = RightLeftRotation(rt);
                }
            } else {
                rt.lc = Delete(value, rt.lc);
                if (Height(rt.lc) - Height(rt.rc) > 1) {
                    if (value < rt.lc.val) {
                        rt = RightRotation(rt);
                    } else
                        rt = LeftRightRotation(rt);
                }
            }
        }
        return rt;

    }

    Integer Height(NodeAVL a) {
        if (a == null)
            return -1;
        Integer lc = Height(a.lc);
        Integer rc = Height(a.rc);
        return Math.max(lc, rc) + 1;
    }

    public NodeAVL RightRotation(NodeAVL X) {
        NodeAVL temp = X.lc;
        X.lc = temp.rc;
        temp.rc = X;
        return temp;
    }

    public NodeAVL LeftRotation(NodeAVL X) {
        NodeAVL temp = X.rc;
        X.rc = temp.lc;
        temp.lc = X;
        return temp;

    }

    public NodeAVL RightLeftRotation(NodeAVL X) {
        X.rc = RightRotation(X.rc);
        return LeftRotation(X);
    }

    public NodeAVL LeftRightRotation(NodeAVL X) {
        X.lc = LeftRotation(X.lc);
        return RightRotation(X);
    }

    public void infixTraverse(NodeAVL r) {
        if (r == null)
            return;
        infixTraverse(r.lc);
        System.out.print(r.val + "\t");
        infixTraverse(r.rc);
    }

}
