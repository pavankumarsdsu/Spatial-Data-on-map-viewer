package main;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;

import javax.swing.*;
import oracle.sql.*;

public class killer_tomato extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String query = "select * from us_census";
	ResultSet rs;
	int scale = 2;
	int[] ia3;
	int[] ia4;
	int flag = 0;

	public static void main(String[] aa) {
		killer_tomato disp = new killer_tomato();
		disp.func();

	}

	public void func() {

		JFrame frame = new JFrame("Killer Tomato-KaiLi");
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();

		JTextField input1 = new JTextField();
		JTextField input2 = new JTextField();
		JTextField input3 = new JTextField();

		panel.setBounds(0, 0, 1000, 80);
		panel1.setBounds(0, 80, 1000, 80);

		// TWO input Parameter
		// Input is PART_NAME, each features name
		input1.setText("humman_hand_left");
		input2.setText("humman_arm_left");
		input3.setText(" Input SQL Command");
		input3.setVisible(true);

		frame.getContentPane().add(panel1, BorderLayout.NORTH);
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		dspimg disp1 = new dspimg();

		panel.setLayout(new GridLayout(2, 7));

		panel1.setLayout(new BorderLayout());

		panel1.setBounds(0, 60, 1000, 80);
		frame.getContentPane().add(disp1, BorderLayout.CENTER);

		// add ten function button
		JButton union = new JButton("UNION");
		JButton intersect = new JButton("INTERSECTION");
		JButton difference = new JButton("DIFFERENCE");
		JButton convexhull = new JButton("CONVEXHULL");
		JButton mbr = new JButton("MBR");
		JButton distance = new JButton("DISTANCE");
		JButton area = new JButton("AREA");
		JButton relate = new JButton("RELATE");
		JButton centroid = new JButton("CENTROID");
		JButton length = new JButton("LENGTH");
		JButton insert = new JButton("INSERT");
		JButton delete = new JButton("DELET" + "E");
		JButton result = new JButton("RESULT");

		panel.add(union);
		panel.add(intersect);
		panel.add(difference);
		panel.add(convexhull);
		panel.add(mbr);
		panel.add(distance);
		panel.add(area);
		panel.add(relate);
		panel.add(centroid);
		panel.add(length);
		panel.add(insert);
		panel.add(delete);
		panel.add(result);

		panel.add(input1);
		panel.add(input2);

		panel1.add(input3);

		union.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("UNION");
				String in1 = input1.getText();
				String in2 = input2.getText();
				query = "select sdo_geom.sdo_union(k1.shape,k2.shape,0.5) shape from us_census k1,us_census k2 where k1.part_name='"
						+ in1 + "' AND k2.part_name='" + in2 + "'";

				System.out.println(query);

				disp1.repaint();

			}

		});

		intersect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("INTERSECTION");
				String in1 = input1.getText();
				String in2 = input2.getText();
				query = "select sdo_geom.sdo_intersection(k1.shape,k2.shape,0.5) shape from us_census k1,us_census k2 where k1.part_name='"
						+ in1 + "' AND k2.part_name='" + in2 + "'";

				System.out.println(query);
				disp1.repaint();

			}

		});

		difference.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("DIFFERENCE");
				String in1 = input1.getText();
				String in2 = input2.getText();
				query = "select sdo_geom.sdo_difference(k1.shape,k2.shape,0.5) shape from us_census k1,us_census k2 where k1.part_name='"
						+ in1 + "' AND k2.part_name='" + in2 + "'";

				System.out.println(query);
				disp1.repaint();

			}

		});

		convexhull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("CONVEXHULL");
				String in1 = input1.getText();

				query = "select sdo_geom.sdo_convexhull(k1.shape,0.5) shape from us_census k1 where k1.part_name='"
						+ in1 + "'";

				System.out.println(query);
				disp1.repaint();

			}

		});

		mbr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("MBR");
				String in1 = input1.getText();

				query = "select sdo_geom.sdo_mbr(k1.shape) shape from us_census k1 where k1.part_name='" + in1
						+ "'";

				System.out.println(query);
				disp1.repaint();

			}

		});

		distance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("DISTANCE");
				String in1 = input1.getText();
				String in2 = input2.getText();
				query = "select sdo_geom.sdo_distance(k1.shape,k2.shape,0.5) shape from us_census k1,us_census k2 where k1.part_name='"
						+ in1 + "' AND k2.part_name='" + in2 + "'";

				System.out.println(query);
				disp1.repaint();

			}

		});

		area.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("AREA");
				String in1 = input1.getText();

				query = "select sdo_geom.sdo_area(k1.shape,0.5) shape from us_census k1 where k1.part_name='" + in1
						+ "'";

				System.out.println(query);

				disp1.repaint();

			}

		});

		relate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("RELATE");// Do the contains
				String in1 = input1.getText();
				String in2 = input2.getText();
				query = "select sdo_geom.relate(k1.shape,'contains',k2.shape,0.5) shape from us_census k1,killer  _tomato k2 where k1.part_name='"
						+ in1 + "' AND k2.part_name='" + in2 + "'";

				System.out.println(query);
				disp1.repaint();

			}

		});

		centroid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("CENTROID");
				String in1 = input1.getText();
				// String in2=input2.getText();
				query = "select sdo_geom.sdo_centroid(k1.shape,0.5) shape from us_census k1 where k1.part_name='"
						+ in1 + "'";

				System.out.println(query);
				disp1.repaint();

			}

		});

		length.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("LENGH");
				String in1 = input1.getText();
				// String in2=input2.getText();
				query = "select sdo_geom.sdo_length(k1.shape,0.5) shape from us_census k1 where k1.part_name='"
						+ in1 + "'";

				System.out.println(query);
				disp1.repaint();

			}

		});

		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("INSERT");
				String in3 = input3.getText();

				query = "INSERT INTO us_census VALUES ( 40,'bird2',MDSYS.SDO_GEOMETRY (2003,null,null,MDSYS.SDO_ELEM_INFO_ARRAY(1,2,2), MDSYS.SDO_ORDINATE_ARRAY(90,260,75,270,60,260,45,270, 30,260)))";
				flag = 1;
				System.out.println(query);
				disp1.repaint();

			}

		});
		// INSERT INTO us_census VALUES ( 13,'humman_body',MDSYS.SDO_GEOMETRY
		// (2003,null,null,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,3),MDSYS.SDO_ORDINATE_ARRAY(280,100,330,160)))

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("DELETE");
				String in3 = input3.getText();
				query = " delete from us_census where PART_NAME='bird2'";

				flag = 1;
				System.out.println(query);
				disp1.repaint();
				// delete from us_census where PART_NAME='humman_body'
			}

		});

		result.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("SHOW RESULT");
				flag = 0;
				query = "select * from us_census";
				disp1.repaint();
				// JOptionPane.showMessageDialog(null,"Answer is :"+s2,"Result
				// Answer",JOptionPane.INFORMATION_MESSAGE);
			}

		});

		frame.setSize(1000, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public class dspimg extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public dspimg() {
		}

		@SuppressWarnings("resource")
		protected void paintComponent(Graphics g) { // override paint

			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;

			g2.translate(0, 700); // move the coordinate

			String url;
			url = "jdbc:oracle:thin:@localhost:1521:orcl";// my oracle database port is 1522
			Statement stmt;
			Connection conn;
			try { // loads drivers
				Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			} catch (Exception e) {
				System.out.println("MR.UnitSitQueries.constructor.Exception: " + e);
			}
			try {

				conn = DriverManager.getConnection(url, "xinchen", "123456"); // my database user and password
				stmt = conn.createStatement();
				if (flag == 1) {
					stmt.executeUpdate(query);
					stmt.executeUpdate("commit;");
					System.out.println(" Successful");
					flag = 0;// set default value=0
					return;
				} else if (flag == 0) {

					rs = stmt.executeQuery(query);
				}

				try {

					while (rs.next()) {

						// String s1 = rs.getString("SHAPE_IDX");
						String s2;
						if ((s2 = rs.getString("shape")) != null) { // Function return value
							System.out.println("Answer: " + s2);
							stmt.close();

							return;
						}

						java.sql.Struct o1 = (java.sql.Struct) rs.getObject("shape");

						if (o1 == null) { // return geom is NULL
							System.out.println("NULL !! ");
							stmt.close();
							return;
						}

						// To calculate the Centroid function
						if ((o1.getAttributes()[2]) != null) {// Whether is a SDO_POINT_TYPE

							oracle.sql.STRUCT oa2 = (oracle.sql.STRUCT) o1.getAttributes()[2];
							// extract first two value, they are x value and y value
							// the third value is in z direction, our graphic is 2D shape,so just ignore it
							BigDecimal ss1 = (BigDecimal) oa2.getAttributes()[0];
							BigDecimal ss2 = (BigDecimal) oa2.getAttributes()[1];

							String x = ss1.toString();// convert it to string
							String y = ss2.toString();

							// System.out.println(oa2.getSQLTypeName()+"||");

							System.out.println("x= " + x);
							System.out.println("y= " + y);
							stmt.close();
							return;
						}

						oracle.sql.ARRAY oa3 = (oracle.sql.ARRAY) o1.getAttributes()[3];
						oracle.sql.ARRAY oa4 = (oracle.sql.ARRAY) o1.getAttributes()[4];
						// String sss = oa3.getBaseTypeName();
						// System.out.println(sss);
						ia3 = oa3.getIntArray();
						ia4 = oa4.getIntArray();
						int len3 = ia3.length;
						int len4 = ia4.length;
						// System.out.println(len4);

						for (int i = 0; i < len4; i++) {
							ia4[i] = ia4[i] * scale;// scale the coordinate

						}
						int count = 1;
						int tlen = 0;
						int inxx = 0;
						int temp = 0;

						if (ia3[1] == 4) {// Compound line
							inxx = inxx + 3;// set inital index=3,just skip first 3 number

							count = count + 1;// this means the second triple

						} else if (ia3[1] == 1005) {// Compound polygon
							inxx = inxx + 3;// set inital index=3,just skip first 3 number
							temp = 1;// this is a flag, if it's Compound polygon, when changing draw type, there is a
										// point which we need to use it twice

							count = count + 1;// begin with the second triple in sdo_elem_info_array

						}

						for (int k = inxx; k < len3; k = k + 3) {// deal with each independent part in one features

							if (len3 > count * 3) {
								tlen = ia3[k + 3]; // get the length of each part

							} else {
								tlen = len4; // features only include one part
							}
							int inx = ia3[k] - 1; // get index of each part

							if (temp == 1 && count > 1 && len3 > count * 3) {// deal with Compound polygon
								tlen = tlen + 2;// add each draw method 2 number length(which is one point)
							}

							if (ia3[k + 2] == 1) { // draw line
								// System.out.println("line");

								int x = ia4[inx];
								int y = ia4[inx + 1];

								// System.out.println(inx+"||"+tlen);

								for (int i = inx + 2; i < tlen - 1; i = i + 2) {

									// System.out.println(x+"||"+y+"||"+ia4[i]+"||"+ia4[i+1]);

									g2.drawLine(x, -y, ia4[i], -ia4[i + 1]);

									x = ia4[i];
									y = ia4[i + 1];

								}

							} else if (ia3[k + 2] == 2 && ia3[k + 1] != 1003) {// draw arc
								// System.out.println("arc");

								double x1 = ia4[inx];
								double y1 = ia4[inx + 1];

								for (int i = inx + 2; i < tlen - 1; i = i + 4) {
									int x0 = 0, y0 = 0, r = 0;
									// double x1=ia4[inx];
									// double y1=ia4[inx+1];
									double x2 = ia4[i];
									double y2 = ia4[i + 1];
									double x3 = ia4[i + 2];
									double y3 = ia4[i + 3];

									// calculate the origin point and radius of the circle
									// arc is a part of the circle
									x0 = (int) Math.round(((y2 * y2 + x2 * x2 - x1 * x1 - y1 * y1) * (y3 - y2)
											- (x3 * x3 + y3 * y3 - x2 * x2 - y2 * y2) * (y2 - y1)) / 2
											/ ((y2 - y1) * (x2 - x3) - (y3 - y2) * (x1 - x2)));
									y0 = (int) Math.round(((x1 * x1 + y1 * y1 - x2 * x2 - y2 * y2) * (x2 - x3)
											- (x2 * x2 + y2 * y2 - x3 * x3 - y3 * y3) * (x1 - x2)) / 2
											/ ((y3 - y2) * (x1 - x2) - (y2 - y1) * (x2 - x3)));
									r = (int) Math.round(Math.sqrt(((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0))));

									int startAngle = getAngle(x1 - x0, y1 - y0);
									int midAngle = getAngle(x2 - x0, y2 - y0);
									int endAngle = getAngle(x3 - x0, y3 - y0);

									if (endAngle < startAngle) {
										int tempAngle = startAngle;
										startAngle = endAngle;
										endAngle = tempAngle;
									}

									int xx1 = (int) Math.round(x0 - r);
									int yy1 = (int) Math.round(y0 + r);

									if (midAngle >= startAngle && midAngle <= endAngle) {
										g2.drawArc(xx1, -yy1, r * 2, r * 2, startAngle, endAngle - startAngle);
									} else {
										g2.drawArc(xx1, -yy1, r * 2, r * 2, endAngle, startAngle + 360 - endAngle);
									}
									x1 = ia4[i + 2];
									y1 = ia4[i + 3];

								}

							} else if (ia3[k + 2] == 3 && ia3[k + 1] == 1003) {// draw rectangle

								// System.out.println("rextangle");
								for (int i = inx; i < tlen; i = i + 4) {
									int width = Math.abs(ia4[i] - ia4[i + 2]);
									int height = Math.abs(ia4[i + 1] - ia4[i + 3]);

									g2.drawRect(ia4[i], -ia4[i + 3], width, height);

								}

							} else if (ia3[k + 2] == 4 || (ia3[k + 2] == 2 && ia3[k + 1] == 1003)) {// draw circle
								// System.out.println("circle");

								int x0, y0, r;
								double x1 = ia4[inx];
								double y1 = ia4[inx + 1];
								double x2 = ia4[inx + 2];
								double y2 = ia4[inx + 3];
								double x3 = ia4[inx + 4];
								double y3 = ia4[inx + 5];
								// calculate the origin point and radius of the circle
								x0 = (int) Math.round(((y2 * y2 + x2 * x2 - x1 * x1 - y1 * y1) * (y3 - y2)
										- (x3 * x3 + y3 * y3 - x2 * x2 - y2 * y2) * (y2 - y1)) / 2
										/ ((y2 - y1) * (x2 - x3) - (y3 - y2) * (x1 - x2)));
								y0 = (int) Math.round(((x1 * x1 + y1 * y1 - x2 * x2 - y2 * y2) * (x2 - x3)
										- (x2 * x2 + y2 * y2 - x3 * x3 - y3 * y3) * (x1 - x2)) / 2
										/ ((y3 - y2) * (x1 - x2) - (y2 - y1) * (x2 - x3)));
								r = (int) Math.sqrt(((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0)));
								g2.drawOval(x0 - r, -(y0 + r), r * 2, r * 2);

							} else {
								break;
							}
							count++; // count the triple numbers

						}

						ia3 = null;// initial ia3
						ia4 = null;// initial ia4
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (SQLException e) {
				System.out.println("OOPS");
			}

		}

		private int getAngle(double x, double y) {
			int angle = (int) Math.round(Math.atan(y / x) / Math.PI * 180);
			if (x < 0) {
				angle = angle + 180;
			}
			if (angle < 0) {
				angle = angle + 360;
			}
			return angle;
		}

	}

}