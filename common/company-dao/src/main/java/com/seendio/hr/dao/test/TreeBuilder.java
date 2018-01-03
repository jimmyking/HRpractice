package com.seendio.hr.dao.test;

import java.util.ArrayList;
import java.util.List;

public class TreeBuilder {

    List<com.seendio.hr.dao.pojo.Node> nodes = new ArrayList<>();

    public TreeBuilder(List<com.seendio.hr.dao.pojo.Node> nodes) {
        super();
        this.nodes = nodes;
    }

    public String buildTree(List<com.seendio.hr.dao.pojo.Node> nodes) {

        TreeBuilder treeBuilder = new TreeBuilder(nodes);

        return treeBuilder.buildTree(nodes);

    }

//    public TreeBuilder(List<com.seendio.hr.dao.pojo.Node> nodes) {
//    }

//    public TreeBuilder(List<Node> nodes) {
//        super();
//        this.nodes = nodes;
//    }

    // 构建JSON树形结构
//    public String buildJSONTree() {
//        List<Node> nodeTree = buildTree();
//        JSONArray jsonArray = JSONArray.fromObject(nodeTree);
//        return jsonArray.toString();
//    }

    // 构建树形结构
    public List<com.seendio.hr.dao.pojo.Node> buildTree() {
        List<com.seendio.hr.dao.pojo.Node> treeNodes = new ArrayList<>();
        List<com.seendio.hr.dao.pojo.Node> rootNodes = getRootNodes();
        for (com.seendio.hr.dao.pojo.Node rootNode : rootNodes) {
            buildChildNodes(rootNode);
            treeNodes.add(rootNode);
        }
        return treeNodes;
    }

    // 递归子节点
    public void buildChildNodes(com.seendio.hr.dao.pojo.Node node) {
        List<com.seendio.hr.dao.pojo.Node> children = getChildNodes(node);
        if (!children.isEmpty()) {
            for (com.seendio.hr.dao.pojo.Node child : children) {
                buildChildNodes(child);
            }
            node.setChildren(children);
        }
    }

    // 获取父节点下所有的子节点
    public List<com.seendio.hr.dao.pojo.Node> getChildNodes(com.seendio.hr.dao.pojo.Node pnode) {
        List<com.seendio.hr.dao.pojo.Node> childNodes = new ArrayList<>();
        for (com.seendio.hr.dao.pojo.Node n : nodes) {
            if (pnode.getId()==n.getDepid()) {
                childNodes.add(n);
            }
        }
        return childNodes;
    }

    // 判断是否为根节点
    public boolean rootNode(com.seendio.hr.dao.pojo.Node node) {
        boolean isRootNode = true;

            if (node.getDepid()!=0) {

                isRootNode = false;


        }
        return isRootNode;
    }

    // 获取集合中所有的根节点
    public List<com.seendio.hr.dao.pojo.Node> getRootNodes() {
        List<com.seendio.hr.dao.pojo.Node> rootNodes = new ArrayList<>();
        for (com.seendio.hr.dao.pojo.Node n : nodes) {

            if (rootNode(n)) {
                rootNodes.add(n);
            }
        }
        return rootNodes;
    }}


