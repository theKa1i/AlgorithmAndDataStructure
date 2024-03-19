package LCR;

public class LCR_064 {
}

class MagicDictionary {
    class TrieNode {
        boolean isEnd;
        TrieNode[] child = new TrieNode[26];
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for(String str : dictionary) {
            TrieNode p = root;
            for(int i = 0; i < str.length(); ++i) {
                int num = str.charAt(i) - 'a';
                if(p.child[num] == null) {
                    p.child[num] = new TrieNode();
                }
                p = p.child[num];
            }
            p.isEnd = true;
        }
    }

    public boolean search(String searchWord) {
        int n = searchWord.length();
        TrieNode p = root;
        for(int i = 0; i < n; ++i) {
            // 当前字母
            int num = searchWord.charAt(i) - 'a';

            // 替换成其他的字母
            for(int x = 0; x < 26; ++x) {
                if(x == num || p.child[x] == null) {
                    continue;
                }

                // 只要后面的字符串匹配成功一次就返回true
                if(contain(p.child[x], searchWord.substring(i + 1))) {
                    return true;
                }
            }

            // 当前字符不存在，所以他不能被替换
            if(p.child[num] == null) {
                return false;
            }
            p = p.child[num];
        }
        return false;
    }
    public boolean contain(TrieNode p, String word) {
        for(int i = 0; i < word.length(); ++i) {
            int num = word.charAt(i) - 'a';
            if(p.child[num] == null) {
                return false;
            }
            p = p.child[num];
        }
        return p.isEnd;
    }
}