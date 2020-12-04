class BuscaBinariaArvore { 

    class No  
    { 
        int chave; 
        No esq, dir; 
  
        public No(int item) 
        { 
            chave = item; 
            esq = dir = null; 
        } 
    } 
  
    // Root of BST 
    No raiz; 
    String toString="";
    // Constructor 
    public BuscaBinariaArvore()  
    {  
         raiz = null;  
    } 
  
    // This method mainly calls insertRec() 
    public void insert(int key)  
    {  
         raiz = insertRec(raiz, key);  
    } 
  
    /* A recursive function to  
       insert a new key in BST */
    No insertRec(No _raiz, int _chave) 
    { 
  
        /* If the tree is empty, 
           return a new node */
        if (_raiz == null)  
        { 
            _raiz = new No(_chave); 
            return _raiz; 
        } 
  
        /* Otherwise, recur down the tree */
        if (_chave < _raiz.chave) 
            _raiz.esq = insertRec(_raiz.esq, _chave); 
        else if (_chave > _raiz.chave) 
            _raiz.dir = insertRec(_raiz.dir, _chave); 
  
        /* return the (unchanged) node pointer */
        return _raiz; 
    } 
  
    // This method mainly calls InorderRec() 
    public String format()  
    {  
        inorderRec(raiz);  
        return toString;
    } 
  
    // A utility function to  
    // do inorder traversal of BST 
    void inorderRec(No root) 
    { 
        String s="";
        if (root != null) { 
            inorderRec(root.esq); 
            s=String.valueOf(root.chave);
            if(!s.equals("")){
                toString+=s+"\n"; 
             }
            inorderRec(root.dir); 
        } 
        
        
    } 
    public boolean find(No root, int key) 
{ 
    // Base Cases: root is null or key is present at root 
    if(root==null)return false;
    if (root.chave==key) 
        return true; 
    
    // Key is greater than root's key 
    if (root.chave < key) 
       return find(root.dir, key); 
  
    // Key is smaller than root's key 
    return find(root.esq, key); 
} 
}