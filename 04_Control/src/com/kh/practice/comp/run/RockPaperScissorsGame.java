package com.kh.practice.comp.run;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RockPaperScissorsGame extends JFrame {
	private JButton rockButton, paperButton, scissorsButton;
	private JLabel resultLabel, playerLabel, computerLabel, scoreLabel;
	private String[] choices = { "가위", "바위", "보" };
	private ImageIcon[] icons;
	private int playerWins = 0, computerWins = 0, ties = 0;

	public RockPaperScissorsGame() {
		setTitle("가위바위보 게임");
		setSize(400, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		// 이미지 아이콘 로드 및 크기 조정 시작
		icons = new ImageIcon[3];
        icons[0] = new ImageIcon("scissors.png");
        icons[1] = new ImageIcon("rock.png");
        icons[2] = new ImageIcon("paper.png");
        
        for (int i = 0; i < icons.length; i++) {
            Image img = icons[i].getImage();
            Image newImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            icons[i] = new ImageIcon(newImg);
        }
		// 이미지 아이콘 로드 및 크기 조정 끝
        
		rockButton = new JButton("바위", icons[1]);
		paperButton = new JButton("보", icons[2]);
		scissorsButton = new JButton("가위", icons[0]);
		resultLabel = new JLabel("결과가 여기에 표시됩니다");
		playerLabel = new JLabel("플레이어: ");
		computerLabel = new JLabel("컴퓨터: ");
		scoreLabel = new JLabel("전적: 0승 0패 0무");

		add(rockButton);
		add(paperButton);
		add(scissorsButton);
		add(playerLabel);
		add(computerLabel);
		add(resultLabel);
		add(scoreLabel);

		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String playerChoice = ((JButton) e.getSource()).getText();
				int playerIndex = getIndex(playerChoice);
				int computerIndex = (int) (Math.random() * 3);
				String computerChoice = choices[computerIndex];
				String result = determineWinner(playerChoice, computerChoice);

				playerLabel.setIcon(icons[playerIndex]);
				computerLabel.setIcon(icons[computerIndex]);
				resultLabel.setText("결과: " + result);
				updateScore(result);
				scoreLabel.setText(String.format("전적: %d승 %d패 %d무", playerWins, computerWins, ties));
			}
		};

		rockButton.addActionListener(listener);
		paperButton.addActionListener(listener);
		scissorsButton.addActionListener(listener);
	}

	private int getIndex(String choice) {
		for (int i = 0; i < choices.length; i++) {
			if (choices[i].equals(choice)) {
				return i;
			}
		}
		return -1;
	}

	private String determineWinner(String playerChoice, String computerChoice) {
		if (playerChoice.equals(computerChoice)) {
			return "무승부!";
		} else if ((playerChoice.equals("바위") && computerChoice.equals("가위"))
				|| (playerChoice.equals("보") && computerChoice.equals("바위"))
				|| (playerChoice.equals("가위") && computerChoice.equals("보"))) {
			return "플레이어 승리!";
		} else {
			return "컴퓨터 승리!";
		}
	}

	private void updateScore(String result) {
		if (result.equals("플레이어 승리!")) {
			playerWins++;
		} else if (result.equals("컴퓨터 승리!")) {
			computerWins++;
		} else {
			ties++;
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new RockPaperScissorsGame().setVisible(true);
		});
	}
}