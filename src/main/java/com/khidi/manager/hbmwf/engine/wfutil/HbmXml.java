/**   
* @Title: HbmXml.java 
* @Package com.khidi.manager.hbm.engine.wfutil 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月20日 下午2:09:42 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.wfutil;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.khidi.manager.hbmwf.engine.wfobj.uiFlow.HbmwfuientWfLine;
import com.khidi.manager.hbmwf.engine.wfobj.uiFlow.HbmwfuientWfNode;
import com.khidi.manager.hbmwf.engine.wfobj.uiFlow.HbmwfuientWfobj;

/**
 * @author Administrator
 *
 */
public class HbmXml {
	private static String xml01 = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><wf>  <snode id=\"s001\" nxtid=\"c001\" x=\"100\" y=\"100\" />  "
			+ "<cnode id=\"c001\" nxtid=\"c002,c003\" x=\"190\" y=\"100\" width=\"80\" height=\"30\" text=\"keveri\" />  "
			+ "<cnode id=\"c002\" nxtid=\"c004\" x=\"280\" y=\"100\" width=\"80\" height=\"30\" text=\"chuveri\"/>  "
			+ "<cnode id=\"c003\" nxtid=\"c004\" x=\"280\" y=\"200\" width=\"80\" height=\"30\" text=\"chuveri01\"/>  "
			+ "<cnode id=\"c004\" multilogic=\"and\" nxtid=\"e001\" x=\"370\" y=\"100\" width=\"80\" height=\"30\" text=\"tingveri\" />  "
			+ "<enode id=\"e001\" x=\"460\" y=\"100\" /></wf>";

	public static void Test() {
		// 创建一个DocumentBuilderFactory的对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 创建一个DocumentBuilder的对象
		try {
			// 创建DocumentBuilder对象
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 通过DocumentBuilder对象的parser方法加载books.xml文件到当前项目下
			Document document = db.parse(new InputSource(new ByteArrayInputStream(xml01.getBytes("utf-8"))));
			// 获取所有book节点的集合
			NodeList cnodeList = document.getElementsByTagName("cnode");
			// 通过nodelist的getLength()方法可以获取bookList的长度
			System.out.println("一共有" + cnodeList.getLength() + "个cnode节点");
			// 遍历每一个book节点
			for (int i = 0; i < cnodeList.getLength(); i++) {
				System.out.println("=================下面开始遍历第" + (i + 1) + "个节点的内容=================");
				// 通过 item(i)方法 获取一个book节点，nodelist的索引值从0开始
				Node cnode = cnodeList.item(i);
				// 获取book节点的所有属性集合
				NamedNodeMap attrs = cnode.getAttributes();
				System.out.println("第 " + (i + 1) + "个节点共有" + attrs.getLength() + "个属性");
				// 遍历book的属性
				for (int j = 0; j < attrs.getLength(); j++) {
					// 通过item(index)方法获取book节点的某一个属性
					Node attr = attrs.item(j);
					// 获取属性名
					System.out.print("属性名：" + attr.getNodeName());
					// 获取属性值
					System.out.println("--属性值" + attr.getNodeValue());
				}
				// 解析book节点的子节点
				NodeList childNodes = cnode.getChildNodes();
				// 遍历childNodes获取每个节点的节点名和节点值
				System.out.println("第" + (i + 1) + "个节点共有" + childNodes.getLength() + "个子节点");
				for (int k = 0; k < childNodes.getLength(); k++) {
					// 区分出text类型的node以及element类型的node
					if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
						// 获取了element类型节点的节点名
						System.out.print("第" + (k + 1) + "个节点的节点名：" + childNodes.item(k).getNodeName());
						// 获取了element类型节点的节点值
						System.out.println("--节点值是：" + childNodes.item(k).getFirstChild().getNodeValue());
						// System.out.println("--节点值是：" +
						// childNodes.item(k).getTextContent());
					}
				}
				System.out.println("======================结束遍历第" + (i + 1) + "个节点的内容=================");
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static HbmwfuientWfNode _ui_GetSingleNodeByType(List<HbmwfuientWfNode> nodes, String type) {
		for (HbmwfuientWfNode lpWfNode : nodes) {
			if (lpWfNode.getType().toLowerCase().equals(type.toLowerCase())) {
				return lpWfNode;
			}
		}
		return null;
	}

	private static List<HbmwfuientWfNode> _ui_GetMultiNodesByType(List<HbmwfuientWfNode> nodes, String type) {
		List<HbmwfuientWfNode> rtn = new ArrayList<HbmwfuientWfNode>();
		for (HbmwfuientWfNode lpWfNode : nodes) {
			if (lpWfNode.getType().toLowerCase().equals(type.toLowerCase())) {
				rtn.add(lpWfNode);
			}
		}
		return rtn;
	}

	private static String GetNextIds(HbmwfuientWfNode theNode, List<HbmwfuientWfLine> theLines) {
		String rtn = "";
		for (HbmwfuientWfLine lpLine : theLines) {
			if (lpLine.getFrom().equals(theNode.getId())) {
				rtn += lpLine.getTo() + ",";
			}
		}
		if (rtn.endsWith(",")) {
			rtn = rtn.substring(0, rtn.length() - 1);
		}
		return rtn;
	}

	//
	public static String GetXml(HbmwfuientWfobj pUiwfObj) throws ParserConfigurationException {
		//
		List<HbmwfuientWfLine> tmpLines = pUiwfObj.getLines();
		List<HbmwfuientWfNode> tmpNodes = pUiwfObj.getNodes();
		//
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document dom = builder.newDocument();
		// 创建wf root node
		Element rootNode = dom.createElement("wf");
		HbmwfuientWfNode startNode = _ui_GetSingleNodeByType(tmpNodes, HbmwfUtil.WF_UI_NODETYPE_START);

		List<HbmwfuientWfNode> cmnNodes = _ui_GetMultiNodesByType(tmpNodes, HbmwfUtil.WF_UI_NODETYPE_CMN);

		HbmwfuientWfNode endNode = _ui_GetSingleNodeByType(tmpNodes, HbmwfUtil.WF_UI_NODETYPE_END);

		dom.appendChild(rootNode);
		// 创建起始节点
		Element startNodeEle = dom.createElement(HbmwfUtil.WF_NODETAG_START);
		startNodeEle.setAttribute("id", startNode.getId());
		startNodeEle.setAttribute("name", startNode.getName());
		startNodeEle.setAttribute("left", startNode.getLeft());
		startNodeEle.setAttribute("top", startNode.getTop());
		startNodeEle.setAttribute("type", startNode.getType());
		startNodeEle.setAttribute("width", startNode.getWidth());
		startNodeEle.setAttribute("height", startNode.getHeight());
		startNodeEle.setAttribute("alt", startNode.getAlt());
		startNodeEle.setAttribute("nxtids", GetNextIds(startNode, tmpLines));
		startNodeEle.setAttribute("prelogic", "");
		startNodeEle.setAttribute("receiver", "");
		rootNode.appendChild(startNodeEle);

		// 创建普通节点
		for (HbmwfuientWfNode lpNode : cmnNodes) {
			Element lpNodeEle = dom.createElement(HbmwfUtil.WF_NODETAG_CMN);
			lpNodeEle.setAttribute("id", lpNode.getId());
			lpNodeEle.setAttribute("name", lpNode.getName());
			lpNodeEle.setAttribute("left", lpNode.getLeft());
			lpNodeEle.setAttribute("top", lpNode.getTop());
			lpNodeEle.setAttribute("type", lpNode.getType());
			lpNodeEle.setAttribute("width", lpNode.getWidth());
			lpNodeEle.setAttribute("height", lpNode.getHeight());
			lpNodeEle.setAttribute("backto", lpNode.getBackto());
			lpNodeEle.setAttribute("alt", lpNode.getAlt());
			lpNodeEle.setAttribute("nxtids", GetNextIds(lpNode, tmpLines));
			lpNodeEle.setAttribute("prelogic", lpNode.getPrelogic());
			lpNodeEle.setAttribute("receiver", lpNode.getReceiver());
			lpNodeEle.setAttribute("state", "NB");
			//
			rootNode.appendChild(lpNodeEle);
		}

		// 创建结束节点
		Element endNodeEle = dom.createElement(HbmwfUtil.WF_NODETAG_END);
		endNodeEle.setAttribute("id", endNode.getId());
		endNodeEle.setAttribute("name", endNode.getName());
		endNodeEle.setAttribute("left", endNode.getLeft());
		endNodeEle.setAttribute("top", endNode.getTop());
		endNodeEle.setAttribute("type", endNode.getType());
		endNodeEle.setAttribute("width", endNode.getWidth());
		endNodeEle.setAttribute("height", endNode.getHeight());
		endNodeEle.setAttribute("alt", endNode.getAlt());
		endNodeEle.setAttribute("prelogic", endNode.getPrelogic());
		startNodeEle.setAttribute("prelogic", "");
		startNodeEle.setAttribute("receiver", "");
		rootNode.appendChild(endNodeEle);

		// 创建线
		for (HbmwfuientWfLine lpLine : tmpLines) {
			Element lpLineEle = dom.createElement(HbmwfUtil.WF_LINETAG_CMN);
			lpLineEle.setAttribute("type", lpLine.getType());
			lpLineEle.setAttribute("id", lpLine.getId());
			lpLineEle.setAttribute("from", lpLine.getFrom());
			lpLineEle.setAttribute("to", lpLine.getTo());
			lpLineEle.setAttribute("name", lpLine.getName());
			lpLineEle.setAttribute("dash", lpLine.getDash());
			lpLineEle.setAttribute("M", String.valueOf(lpLine.getM()));

			rootNode.appendChild(lpLineEle);
		}

		// dom.appendChild(rootNode);

		System.out.println(dom.getTextContent());
		//
		String xmlStr = toStringFromDoc(dom);
		//
		System.out.println(xmlStr);
		//
		return xmlStr;
	}

	public static String TestXmlMethod() throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document dom = builder.newDocument();
		//
		Element wfRootNode = dom.createElement("wf");
		Element wfNode1 = dom.createElement("cnode");
		wfNode1.setAttribute("id", "node1");
		wfNode1.setAttribute("prelogic", "or");
		//
		wfRootNode.appendChild(wfNode1);
		dom.appendChild(wfRootNode);
		//
		String xmlStr = toStringFromDoc(dom);
		//
		System.out.println(xmlStr);
		//
		return xmlStr;
	}

	private static String toStringFromDoc(Document document) {
		String result = null;

		if (document != null) {
			StringWriter strWtr = new StringWriter();
			StreamResult strResult = new StreamResult(strWtr);
			TransformerFactory tfac = TransformerFactory.newInstance();
			try {
				javax.xml.transform.Transformer t = tfac.newTransformer();
				t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				t.setOutputProperty(OutputKeys.INDENT, "yes");
				t.setOutputProperty(OutputKeys.METHOD, "xml"); // xml, html,
				// text
				t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
				t.transform(new DOMSource(document.getDocumentElement()), strResult);
			} catch (Exception e) {
				System.err.println("XML.toString(Document): " + e);
			}
			result = strResult.getWriter().toString();
			try {
				strWtr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	private static String CorrectWfAttr_Value(String attrName, String attrValue) {
		String rtn = "";

		switch (attrName) {
		case "dash":
			rtn = HbmwfUtil.dd(attrName) + ":" + attrValue;
			return rtn;
		case "M":
		case "m":
			if (attrValue == null || attrValue.equals("")) {

			} else {
				rtn = HbmwfUtil.dd("M") + ":" + attrValue;
			}
			return rtn;
		default:
			rtn = HbmwfUtil.dd(attrName) + ":" + HbmwfUtil.dd(attrValue);
			break;
		}
		return rtn;
	}

	public static String GetFlowJson(String xml, String title)
			throws ParserConfigurationException, UnsupportedEncodingException, SAXException, IOException {
		// String _xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><wf>"
		// + " <snode alt=\"true\" height=\"28\" id=\"demo_node_1\" left=\"42\"
		// name=\"开始\" nxtids=\"demo_node_3\" top=\"38\" type=\"start round
		// mix\" width=\"28\"/>"
		// + " <cnode alt=\"true\" backto=\"\" height=\"28\" id=\"demo_node_3\"
		// left=\"155\" name=\"入职申请\" nxtids=\"demo_node_4\"
		// prelogic=\"and(or)\" top=\"39\" type=\"task\" width=\"104\"/>"
		// + " <cnode alt=\"true\" backto=\"\" height=\"28\" id=\"demo_node_4\"
		// left=\"364\" name=\"人力审批\" nxtids=\"demo_node_3\"
		// prelogic=\"and(or)\" top=\"42\" type=\"task\" width=\"104\"/>"
		// + " <cnode alt=\"true\" backto=\"\" height=\"28\" id=\"demo_node_9\"
		// left=\"559\" name=\"经理终审\" nxtids=\"demo_node_4\"
		// prelogic=\"and(or)\" top=\"141\" type=\"task\" width=\"104\"/>"
		// + " <enode alt=\"true\" height=\"28\" id=\"demo_node_2\" left=\"797\"
		// name=\"结束\" prelogic=\"and(or)\" top=\"42\" type=\"end round mix\"
		// width=\"28\"/>"
		// + " <line M=\"\" dash=\"false\" from=\"demo_node_3\"
		// id=\"demo_line_5\" name=\"提交申请\" to=\"demo_node_4\" type=\"sl\"/>"
		// + " <line M=\"\" dash=\"true\" from=\"demo_node_1\"
		// id=\"demo_line_6\" name=\"\" to=\"demo_node_3\" type=\"sl\"/>"
		// + " <line M=\"\" dash=\"false\" from=\"demo_node_4\"
		// id=\"demo_line_7\" name=\"不通过\" to=\"demo_node_3\" type=\"tb\"/>"
		// + " <line M=\"\" dash=\"true\" from=\"demo_node_4\"
		// id=\"demo_line_10\" name=\"通过\" to=\"demo_node_8\" type=\"sl\"/>"
		// + " <line M=\"\" dash=\"true\" from=\"demo_node_9\"
		// id=\"demo_line_11\" name=\"不接受\" to=\"demo_node_4\" type=\"tb\"/>"
		// + " <line M=\"\" dash=\"false\" from=\"demo_node_8\"
		// id=\"demo_line_12\" name=\"大于8000\" to=\"demo_node_9\" type=\"sl\"/>"
		// + " <line M=\"\" dash=\"false\" from=\"demo_node_8\"
		// id=\"demo_line_13\" name=\"小于8000\" to=\"demo_node_2\" type=\"sl\"/>"
		// + " <line M=\"\" dash=\"false\" from=\"demo_node_9\"
		// id=\"demo_line_14\" name=\"接受\" to=\"demo_node_2\" type=\"sl\"/>"
		// + "</wf>";
		System.out.println(xml);
		String _xml = xml;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(new InputSource(new ByteArrayInputStream(_xml.getBytes("utf-8"))));
		NodeList cnodeList0 = document.getElementsByTagName("cnode");
		NodeList cnodeList1 = document.getElementsByTagName("snode");
		NodeList cnodeList2 = document.getElementsByTagName("enode");

		String nodeList = "{";

		// start node
		NamedNodeMap attrs1 = cnodeList1.item(0).getAttributes();
		nodeList += HbmwfUtil.dd("__id__") + " : {";
		for (int j = 0; j < attrs1.getLength(); j++) {
			Node attr = attrs1.item(j);
			String lpItem = CorrectWfAttr_Value(attr.getNodeName(), attr.getNodeValue());
			if (attr.getNodeName().toLowerCase().equals("id")) {
				nodeList = nodeList.replace("__id__", attr.getNodeValue());
			}
			nodeList += lpItem + ",";
		}
		if (nodeList.endsWith(",")) {
			nodeList = nodeList.substring(0, nodeList.length() - 1);
		}
		nodeList += "},";
		//
		// end node
		NamedNodeMap attrs2 = cnodeList2.item(0).getAttributes();
		nodeList += HbmwfUtil.dd("__id__") + " : {";
		for (int j = 0; j < attrs2.getLength(); j++) {
			Node attr = attrs2.item(j);
			String lpItem = CorrectWfAttr_Value(attr.getNodeName(), attr.getNodeValue());
			if (attr.getNodeName().toLowerCase().equals("id")) {
				nodeList = nodeList.replace("__id__", attr.getNodeValue());
			}
			nodeList += lpItem + ",";
		}
		if (nodeList.endsWith(",")) {
			nodeList = nodeList.substring(0, nodeList.length() - 1);
		}
		nodeList += "},";
		//
		for (int i = 0; i < cnodeList0.getLength(); i++) {
			Node cnode = cnodeList0.item(i);
			NamedNodeMap attrs = cnode.getAttributes();
			nodeList += HbmwfUtil.dd("__id__") + " : {";
			for (int j = 0; j < attrs.getLength(); j++) {
				Node attr = attrs.item(j);
				String lpItem = CorrectWfAttr_Value(attr.getNodeName(), attr.getNodeValue());
				if (attr.getNodeName().toLowerCase().equals("id")) {
					nodeList = nodeList.replace("__id__", attr.getNodeValue());
				}
				nodeList += lpItem + ",";
			}
			if (nodeList.endsWith(",")) {
				nodeList = nodeList.substring(0, nodeList.length() - 1);
			}
			nodeList += "},";
		}
		if (nodeList.endsWith(",")) {
			nodeList = nodeList.substring(0, nodeList.length() - 1);
		}
		nodeList += "}";

		// get lines
		String lineList = "{";
		NodeList nodeLines = document.getElementsByTagName("line");
		for (int i = 0; i < nodeLines.getLength(); i++) {
			Node cnode = nodeLines.item(i);
			NamedNodeMap attrs = cnode.getAttributes();
			lineList += HbmwfUtil.dd("__id__") + " : {";
			for (int j = 0; j < attrs.getLength(); j++) {
				Node attr = attrs.item(j);
				String lpItem = CorrectWfAttr_Value(attr.getNodeName(), attr.getNodeValue());
				if (attr.getNodeName().toLowerCase().equals("id")) {
					lineList = lineList.replace("__id__", attr.getNodeValue());
				}
				lineList += lpItem + ",";
			}
			if (lineList.endsWith(",")) {
				lineList = lineList.substring(0, lineList.length() - 1);
			}
			lineList += "},";
		}
		if (lineList.endsWith(",")) {
			lineList = lineList.substring(0, lineList.length() - 1);
		}
		lineList += "}";
		//
		String rtn = "{\"title\":" + HbmwfUtil.dd(title) + " , \"nodes\":" + nodeList + ",\"lines\":" + lineList
				+ ",\"areas\":{},\"initNum\":\"16\"}";
		//
		return rtn.replace("\"", "\\\"");
	}

	public static String GetXmlFromDoc(Document document) {
		String result = null;

		if (document != null) {
			StringWriter strWtr = new StringWriter();
			StreamResult strResult = new StreamResult(strWtr);
			TransformerFactory tfac = TransformerFactory.newInstance();
			try {
				javax.xml.transform.Transformer t = tfac.newTransformer();
				t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				t.setOutputProperty(OutputKeys.INDENT, "yes");
				t.setOutputProperty(OutputKeys.METHOD, "xml"); // xml, html,
				// text
				t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
				t.transform(new DOMSource(document.getDocumentElement()), strResult);
			} catch (Exception e) {
				System.err.println("XML.toString(Document): " + e);
			}
			result = strResult.getWriter().toString();
			try {
				strWtr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	/************************* 工具 **********************/
	private static boolean _HaveNodeAttribute(Node node, String attrName) {
		NamedNodeMap attrs = node.getAttributes();
		boolean exists = false;
		for (int j = 0; j < attrs.getLength(); j++) {
			String attrName0 = attrs.item(j).getNodeName();
			if (attrName0.equals(attrName)) {
				return true;
			}
		}
		return false;
	}

	private static Attr _CreateAttribute(Document doc, Node node, String attributeName, String value) {
		Attr attr = doc.createAttribute(attributeName);
		attr.setValue(value);

		node.getAttributes().setNamedItem(attr);
		//
		return attr;
	}

	private static void _SetNodeAttribute(Node node, String attrName, String attrValue) {
		NamedNodeMap attrs = node.getAttributes();
		for (int j = 0; j < attrs.getLength(); j++) {
			String attrName0 = attrs.item(j).getNodeName();
			String attrValue0 = attrs.item(j).getNodeValue();
			if (attrName0.equals(attrName)) {
				attrs.item(j).setNodeValue(attrValue);
			}
		}
	}

	private static String _GetNodeAttrValue(Node node, String attrName) {
		NamedNodeMap attrs = node.getAttributes();
		for (int j = 0; j < attrs.getLength(); j++) {
			String attrName0 = attrs.item(j).getNodeName();
			String attrValue0 = attrs.item(j).getNodeValue();
			//
			if (attrName0.toLowerCase().equals(attrName.toLowerCase())) {
				return attrValue0;
			}
		}
		return null;
	}

	public static void SetNodeAttribute(Document doc, Node node, String attributeName, String value,
			boolean noneCreate) {
		boolean haveAttr = _HaveNodeAttribute(node, attributeName);
		//
		if (haveAttr) {
			_SetNodeAttribute(node, attributeName, value);
		} else {
			if (noneCreate) {
				_CreateAttribute(doc, node, attributeName, value);
			}
		}
	}

	public static String GetNodeAttribute(Document doc, Node node, String attributeName, boolean noneCreate,
			String defaultValue) {
		boolean haveAttr = _HaveNodeAttribute(node, attributeName);
		//
		if (haveAttr) {
			String rtn0 =  _GetNodeAttrValue(node, attributeName);
			if(rtn0.equals(""))
			{
				rtn0 = defaultValue;
			}
			return rtn0;
		} else {
			if (noneCreate) {
				_CreateAttribute(doc, node, attributeName, defaultValue);
				return defaultValue;
			}
		}
		return null;
	}
}
