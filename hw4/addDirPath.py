if __name__ == '__main__':
	with open('./pageRank.txt') as f:
		s = ''
		for line in f.readlines(): 
			s += '/Users/lacticacid/Desktop/2018 Fall/CSCI 572/Homework/4/mercurynews/mercurynews_html_files/' + line

	with open('./pageRank.txt', 'w+') as f:
		f.write(s)
