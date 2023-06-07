package com.geraldo.demanda.nerd.gui;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import com.geraldo.demanda.nerd.entidade.Aluno;
import com.geraldo.demanda.nerd.report.relatorio.Relatorio;

import net.sf.jasperreports.engine.JRException;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JTextField tfMatricula;
	private JTextField tfNome;
	private JTextField tfNota;
	private JTextField tfFaltas;
	
	private JTextArea taPainel;
	
	private JButton btnGravar;
	private JButton btnRelatorio;
	
	private List<Aluno> lista = new ArrayList<Aluno>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome: ");
		
		JLabel lblMatricula = new JLabel("Matrícula: ");
		
		JLabel lblNota = new JLabel("Nota: ");
		
		JLabel lblFaltas = new JLabel("Faltas: ");
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		
		tfMatricula = new JTextField();
		tfMatricula.setColumns(10);
		
		tfNota = new JTextField();
		tfNota.setColumns(10);
		
		tfFaltas = new JTextField();
		tfFaltas.setColumns(10);
		
		
		
		btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				criarAluno();
			}
		});
		 
		
		btnRelatorio = new JButton("Relatório");
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarRelatório();
			}
		});
		
		
		JScrollPane scrollPane = new JScrollPane();
			
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMatricula)
								.addComponent(lblNota)
								.addComponent(lblNome)
								.addComponent(lblFaltas))
							.addGap(16)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(tfFaltas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
									.addComponent(btnGravar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
									.addGap(30))
								.addComponent(tfNota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfNome, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
								.addComponent(tfMatricula, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
							.addGap(0)
							.addComponent(btnRelatorio)))
					.addGap(33))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMatricula)
						.addComponent(tfMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNota)
						.addComponent(tfNota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFaltas)
						.addComponent(btnRelatorio)
						.addComponent(btnGravar)
						.addComponent(tfFaltas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		taPainel = new JTextArea();
		scrollPane.setViewportView(taPainel);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	private void criarAluno() {
		Aluno aluno = new Aluno();
		aluno.setNome( tfNome.getText() );
		aluno.setMatricula( tfMatricula.getText() );
		aluno.setNota( Double.parseDouble(tfNota.getText()) );
		aluno.setFaltas( Integer.parseInt(tfFaltas.getText()) );
		
		lista.add(aluno);
		taPainel.append(aluno.toString());
		limpar();
	}
	
	private void limpar() {
		
		for (int i = 0; i < contentPane.getComponentCount(); i++) {
			Component c = contentPane.getComponent(i);
			if( c instanceof JTextField ) {
				JTextField campo = (JTextField) c;
				campo.setText(null);
			}
		}
	}
	
	private void criarRelatório() {
		
		Relatorio relatorio =  new Relatorio();
		
		try {
			relatorio.gerarRelatorio(lista);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
