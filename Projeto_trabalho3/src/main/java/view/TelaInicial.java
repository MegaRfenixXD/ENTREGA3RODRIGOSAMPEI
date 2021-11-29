package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;

import Classes.Inimigo;
import Classes.Jogos;
import Classes.Main;
import conexao.IniciaBanco;
import dao.JogosDAO;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;


public class TelaInicial{

	private JFrame frame;
	public JTextField NomeText;
	public static int test;
	public String recebenome;
	public boolean nomerepetido ;
	public int danodef = 8;
	public int vidadef = 8;
	
	
	

	Jogos jogos = new Jogos();
	JogosDAO jogosDAO = new JogosDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.setBounds(100, 100, 584, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel Label1 = new JLabel("RPG FIGHTERS");
		Label1.setFont(new Font("Arial Black", Font.BOLD, 57));
		
		
		// CLASSE LABELS
		
		
		JLabel label2 = new JLabel("Classe:");
		
		NomeText = new JTextField();
		NomeText.setColumns(10);
		
		JLabel label3 = new JLabel("Nome:");
		
		JLabel lblNewLabel = new JLabel("Apareceu um goblin selvagem voc\u00EA deseja derrotalo ?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		

		
		
		JList list = new JList();
		
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setModel(new AbstractListModel() {
			
			// ARRAY DE CLASSES
			
			String[] values = new String[] {"Guerreiro", "Arqueiro", "Mago"};
			
			
			
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		
		
		list.setToolTipText("AKI AO");
		
		
		
		
		JButton btnNewButton = new JButton("BATALHAR!!!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				int vigu = 16 , viar = 11 ,vima = 8;
				int danogu=4 , danoar=6 , danoma = 8;
				int danomonstro=6;
				int vidamonstro = 14;
				int danodef=0;
				int vidadef=0;
				int contador=1;
				Jogos jogos = new Jogos();
				TelaInicial tela = new TelaInicial();	
				
				if(list.getSelectedValue() == "Guerreiro") {
					 
					 recebenome = "Guerreiro";
					 danodef = 4;
					 vidadef = 16;
					 
					 while(vigu>0 || vidamonstro>0) {
						
						danogu = (int)(Math.random() * 4);
						vidamonstro = vidamonstro - danogu;
						
						 danomonstro = (int)(Math.random() * 6);
						vigu = vigu - danomonstro;
						
					
				        

						if(vidamonstro<=0) {
							JOptionPane.showMessageDialog(null,"Numero de lutas:"+contador);
							contador++;
							JOptionPane.showMessageDialog(null, "Nome:"+ NomeText.getText() + "\nclasse:" + list.getSelectedValuesList()+"\n");
							JOptionPane.showMessageDialog(null,"\n Danos FINAIS\n Dano Causado:" +danogu + "Vida Atual:"+ vigu +"\n Dano Recebido:"+ danomonstro +" Vida do Inimigo:" + vidamonstro +"\n Você Ganhou");
						}
					 
					 if(vigu<=0) {
						 JOptionPane.showMessageDialog(null,"Numero de lutas:"+contador);
							contador++;
							JOptionPane.showMessageDialog(null, "Nome:"+ NomeText.getText() + "\nclasse:" + list.getSelectedValuesList()+"\n");
				        	JOptionPane.showMessageDialog(null,"DANOS FINAIS\n Dano Causado:" +danogu + "Vida Atual:"+ vigu +"\n Dano Recebido:"+ danomonstro +" Vida do Inimigo:" + vidamonstro +"\n Você Morreu");
						}
				}
				}
			
				
				
				if(list.getSelectedValue() == "Arqueiro") {
				    recebenome = "Arqueiro";
					danodef = 6;
					vidadef = 11;
					
					while(viar>0 || vidamonstro>0) {
					
					danoar = (int)(Math.random() * 6);
					vidamonstro = vidamonstro - danoar;
					
					danomonstro = (int)(Math.random() * 6);
					viar = viar - danomonstro;
					
				
			        if(viar<=0) {
			        	JOptionPane.showMessageDialog(null,"Numero de lutas:"+contador);
						contador++;
						JOptionPane.showMessageDialog(null, "Nome:"+ NomeText.getText() + "\nclasse:" + list.getSelectedValuesList()+"\n");
			        	JOptionPane.showMessageDialog(null,"\nDANOS FINAIS \n Dano Causado:" +danoar + "Vida Atual:"+ viar +"\n Dano Recebido:"+ danomonstro +" Vida do Inimigo:" + vidamonstro +"\n Você Morreu");
					}

					if(vidamonstro<=0) {
						JOptionPane.showMessageDialog(null,"Numero de lutas:"+contador);
						contador++;
						JOptionPane.showMessageDialog(null, "Nome:"+ NomeText.getText() + "\nclasse:" + list.getSelectedValuesList()+"\n");
						JOptionPane.showMessageDialog(null,"\nDANOS FINAIS \n Dano Causado:" +danoar + "Vida Atual:"+ viar +"\n Dano Recebido:"+ danomonstro +" Vida do Inimigo:" + vidamonstro +"\n Você Ganhou");
					}
					
				}
				
			}
				
				
				if(list.getSelectedValue() == "Mago") {
					
					recebenome = "Mago";
					while(vima>0 || vidamonstro>0) {
					
					danoma = (int)(Math.random() * 8);
					vidamonstro = vidamonstro - danoma;
					
				    danomonstro = (int)(Math.random() * 6);
					vima = vima - danomonstro;
					
				
			        if(vima<=0) {
			        	JOptionPane.showMessageDialog(null,"Numero de lutas:"+contador);
						contador++;
						JOptionPane.showMessageDialog(null, "Nome:"+ NomeText.getText() + "\nclasse:" + list.getSelectedValuesList()+"\n");
			        	JOptionPane.showMessageDialog(null,"\nDANOS FINAIS \n Dano Causado:" +danoma + "Vida Atual:"+ vima +"\n Dano Recebido:"+ danomonstro +" Vida do Inimigo:" + vidamonstro +"\n Você Morreu");
					}

					if(vidamonstro<=0) {
						JOptionPane.showMessageDialog(null,"Numero de lutas:"+contador);
						contador++;
						JOptionPane.showMessageDialog(null, "Nome:"+ NomeText.getText() + "\nclasse:" + list.getSelectedValuesList()+"\n");
						JOptionPane.showMessageDialog(null,"\nDANOS FINAIS \n Dano Causado:" +danoma + "Vida Atual:"+ vima +"\n Dano Recebido:"+ danomonstro +" Vida do Inimigo:" + vidamonstro +"\n Você Ganhou");
					}
					
				}
			}
				
				
					
					
					
					
					
					
				
				
				
				
				
				

				jogos.setId(32L);
				jogos.setNome(NomeText.getText());
				jogos.setClasse(recebenome);
				jogos.setDano(danodef);
				jogos.setVida(vidadef);
				
			
				jogosDAO.salvar(jogos);
				
			}
			
			
				
				
				
				
			
		});
	
	
	
	
		

		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(62)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
							.addGap(161))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label2)
								.addComponent(label3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(NomeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(list, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(449)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(37)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
							.addGap(336))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(Label1)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(Label1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(NomeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label3))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label2)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(171)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(59))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
