import networkx as nx
import matplotlib.pyplot as plt

G = nx.DiGraph()
nodes = [0, 1, 2, 3, 4]
edges = [ (0,1,5),(0,2,3),(0,4,2),(1,2,2),(1,3,6),(2,1,1), (2,3,2),(4,1,6),(4,2,10),(4,3,3) ]
G.add_nodes_from(nodes)
G.add_weighted_edges_from(edges)

G._node[0]['pos'] = (1,10)
G._node[1]['pos'] = (5,3)
G._node[2]['pos'] = (3,-5)
G._node[3]['pos'] = (-1,-4)
G._node[4]['pos'] = (-3,3)

pos=nx.get_node_attributes(G,'pos')
weight=nx.get_edge_attributes(G,'weight')

nx.draw_networkx_nodes(G,pos=pos)
nx.draw_networkx_labels(G,pos=pos)
nx.draw_networkx_edges(G,pos,connectionstyle='arc3, rad = 0.05')
nx.draw_networkx_edge_labels(G,pos=pos,edge_labels=weight,label_pos=0.3)

plt.axis('off')
plt.show()

for i in range(0,4):
    try:
        sp = nx.dijkstra_path(G,source = 4, target = i)
        print("4'ten " + str(i) + "'ye en kisa yol: " + str(sp))
    except:
        print("4'ten " + str(i) + "'ye yol bulunamadi")


G.remove_node(2)
print("")
print("2 numarali node silindikten sonraki durum:")

pos=nx.get_node_attributes(G,'pos')
weight=nx.get_edge_attributes(G,'weight')

nx.draw_networkx_nodes(G,pos=pos)
nx.draw_networkx_labels(G,pos=pos)
nx.draw_networkx_edges(G,pos,connectionstyle='arc3, rad = 0.05')
nx.draw_networkx_edge_labels(G,pos=pos,edge_labels=weight,label_pos=0.3)
plt.axis('off')
plt.show()

for i in range(0,4):
    try:
        sp = nx.dijkstra_path(G,source = 4, target = i)
        print("4'ten " + str(i) + "'ye en kisa yol: " + str(sp))
    except:
        print("4'ten " + str(i) + "'ye yol bulunamadi")

