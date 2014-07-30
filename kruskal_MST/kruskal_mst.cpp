#include<iostream>
#include<stdlib>
#include<string>
using namespace std;


struct Edge {
	int src;
	int dest;
	int weight;
};

struct Graph {
	int V,E;
	struct Edge* edge;
};

struct Graph* createGraph(int V,int E) {
	struct Graph* graph = (struct Graph *) malloc(sizeof(struct Graph));
	graph->V =V;
	graph->E=E;
	
	graph->edge = (struct Edge*)malloc(sizeof(struct Edge));
	return graph;
}

// A structure to represent a subset for union find

struct subset {
	int parent;
	int rank;
};

int find(struct subset subsets[] , int i) {
		// find root and make root as parent of i 
		if(subsets[i].parent !=i)
			subsets[i].parent = find(subsets, subsets[i].parent);
		return subsets[i].parent;
}

void union(struct subset subsets[], int x, int y) {
	int xroot = find(subsets, x);
	int yroot = find(subsets, y);

	// Attach smaller rank tree under root of high rank tree
	if ( subsets[xroot].rank < subsets[yroot].rank)
		subsets[xroot].parent = yroot;
	else if (subsets[xroot].rank > subsets[yroot].rank)
		subsets[yroot].parent = xroot;
	else{
		subsets[yroot].parent = xroot;
		subsets[xroot].rank++;
	}

}


int mycomp ( const void* a, const void* b) {
	struct Edge* a1 = (struct Edge*) a;
	struct Edge* b1 = (struct Edge*) b;

	return a1->weight > b1->weight;
	
}






void KruskalMST(struct Graph* graph){
	int v = graph->V;
	
	struct Edge result[V]; // this will store resultant MST
	int e =0;
	int i =0;

	qsort(graph->edge, graph->E, sizeof(graph->edge[0]), mycomp);
	
	s		
