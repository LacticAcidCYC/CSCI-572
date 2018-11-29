import networkx as nx
import nose

G = nx.read_edgelist("/Users/lacticacid/Desktop/2018 Fall/CSCI 572/Homework/4/result.txt", create_using=nx.DiGraph())
pr = nx.pagerank(G, alpha=0.85, personalization=None, max_iter=30, tol=1e-06, nstart=None, weight='weight', dangling=None)
f1=open('./pageRank.txt', 'w+')
f1.write(str(pr)[1:-1].replace(', ', '\n').replace("': ","=").replace("u'", ""))