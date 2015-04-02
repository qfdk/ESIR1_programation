/*______________________________*/
/**
 * 
 */
package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Control.Config;
import Control.MyConnection;

/**
 * @author qfdk Cree le 2015年3月29日
 */
public class MaFenetre extends JFrame implements ActionListener
{
	private JPanel jp_top;
	private JPanel jp_mid;
	private JPanel jp_bot;

	private JScrollPane sp_result;
	private JTextArea ta_result;

	private TextField tf_query;
	private JButton bp_query;

	private JLabel lb_status;
	private JButton bp_connnect;
	private JButton bp_disconnect;
	private JButton bp_insert;
	private JButton bp_quite;

	private JButton bp_tousEtudiant;

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	/**
	 * constucteur
	 * 
	 * @param titre
	 *            titre
	 */
	public MaFenetre(String titre)
	{
		super(titre);

		inisialisation();
		placement();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}

	/**
	 * 
	 */
	private void placement()
	{
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(jp_top, BorderLayout.NORTH);
		this.getContentPane().add(jp_mid, BorderLayout.CENTER);
		this.getContentPane().add(jp_bot, BorderLayout.SOUTH);
	}

	/**
	 * 
	 */
	private void inisialisation()
	{
		init_top();
		init_mid();
		init_bot();
	}

	/**
	 * 
	 */
	private void init_bot()
	{
		jp_bot = new JPanel(new GridLayout(1, 5));
		bp_connnect = new JButton("CONNECT");
		bp_disconnect = new JButton("DISCONNECT");
		bp_insert = new JButton("ADD");
		bp_quite=new JButton("Exit");
		bp_quite.addActionListener(this);
		bp_connnect.addActionListener(this);
		bp_disconnect.addActionListener(this);
		bp_insert.addActionListener(this);
		lb_status = new JLabel("[INFO]->Il faut connecter");
		jp_bot.add(lb_status);
		jp_bot.add(bp_connnect);
		jp_bot.add(bp_disconnect);
		jp_bot.add(bp_insert);
		jp_bot.add(bp_quite);
	}

	/**
	 * 
	 */
	private void init_mid()
	{
		jp_mid = new JPanel(new BorderLayout());
		ta_result = new JTextArea();
		sp_result = new JScrollPane(ta_result);
		jp_mid.add(sp_result, BorderLayout.CENTER);
	}

	/**
	 * 
	 */
	private void init_top()
	{
		tf_query = new TextField(30);
		tf_query.setText("SELECT * FROM cours");
		bp_query = new JButton("Query");
		bp_tousEtudiant = new JButton("Etudiants");
		bp_tousEtudiant.addActionListener(this);
		bp_query.addActionListener(this);
		jp_top = new JPanel(new FlowLayout());
		jp_top.add(new Label("SQL => "));
		jp_top.add(tf_query);
		jp_top.add(bp_tousEtudiant);
		jp_top.add(bp_query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == bp_query)
		{
			if (stmt != null)
			{
				ta_result.setText( "---------------------\n");
				executeQuery(tf_query.getText());
			} else
				lb_status.setText("【Status】 ===>OffLine");
		}
		if (e.getSource() == bp_connnect)
		{
			connexion();
		}
		if (e.getSource() == bp_disconnect)
		{
			MyConnection.getInstance().close(rs, stmt, conn);
			rs = null;
			stmt = null;
			conn = null;
			lb_status.setText("【Status】 ===>OffLine");
		}
		if (e.getSource() == bp_tousEtudiant)
		{
			if (stmt != null)
			{
				ta_result.setText( "---------------------\n");
				listEdutiants();
			} else
				lb_status.setText("【Status】 ===>OffLine");
		}
		if(e.getSource()==bp_quite)
		{
			MyConnection.getInstance().close(rs, stmt, conn);
			System.exit(0);
		}
	}

	/**
	 * @param text
	 */
	private void executeQuery(String text)
	{
		try
		{
			rs = stmt.executeQuery(text);
			while (rs.next())
			{
				ta_result.setText(rs.getString(2) + " " + rs.getString(3)
						+ "\n" + ta_result.getText());
			}
			lb_status.setText("【Status】 ===>SUCCESS :)");
		} catch (SQLException e)
		{
			lb_status.setText("【Status】 ===>ERROR :X");
		}

	}

	/**
	 * 
	 */
	private void connexion()
	{
		try
		{
			conn = MyConnection.getInstance().getConnection();
			stmt = conn.createStatement();
			lb_status.setText("【Status】 ===>OnLine :)");
		} catch (SQLException e)
		{
			MyConnection.getInstance().close(rs, stmt, conn);
			e.printStackTrace();
			lb_status.setText("【Status】 ===> ERROR :X");
		}

	}

	/**
	 * @throws SQLException
	 * 
	 */
	private void listEdutiants()
	{
		try
		{
			rs = stmt.executeQuery("SELECT * FROM etudiant");
			while (rs.next())
			{
				ta_result.setText(rs.getString(2) + " " + rs.getString(3)
						+ "\n" + ta_result.getText());
			}
		} catch (SQLException e)
		{
			lb_status.setText("【Status】 ===> No Connecte");
		}
	}

}

/* ______________________________ */
/* ___________FIN_______________ */
/* ______________________________ */