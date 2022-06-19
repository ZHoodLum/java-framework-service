package com.example.ikanalyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.store.RAMDirectory;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：zhangdyp
 * @ Date       ：Created in 2020/7/20
 * @Description:
 */


public class IKAnalyzerSupport {
    private static final Logger LOGGER = LoggerFactory.getLogger(IKAnalyzerSupport.class);

    /**
     * IK分词
     *
     * @param target
     * @return
     */
    public static List<String> iKSegmenterToList(String target) throws Exception {
        if (StringUtils.isEmpty(target)) {
            return Lists.newArrayList();
        }
        List<String> result = new ArrayList<>();
        StringReader sr = new StringReader(target);
        // 关闭智能分词 (对分词的精度影响较大)
        IKSegmenter ik = new IKSegmenter(sr, true);
        Lexeme lex;
        while ((lex = ik.next()) != null) {
            String lexemeText = lex.getLexemeText();
            result.add(lexemeText);
        }

        //LOGGER.info("company:{}, iKSegmenterToList:{}", target, JSON.toJSON(result));
        return result;
    }

    @Test
    public void test() throws Exception {
//        String str = "http://www.relaxheart.cn 是王琦同学的个人兴趣分享网站站点";
        String str = "客户信息账2号";
        System.out.println(iKSegmenterToList(str));
    }
/**
 * --true
 加载扩展词典：ext.dic
 加载扩展停止词典：stopword.dic
 [http, www.relaxheart.cn, 是, 王琦同, 学, 的, 个人兴趣, 分享, 网站, 站点

 --fasle
 加载扩展词典：ext.dic
 加载扩展停止词典：stopword.dic
 [http, www.relaxheart.cn, www, relaxheart, cn, 是, 王琦同, 同学, 的, 个人兴趣, 兴趣, 分享, 网站, 站站, 站点]

 */

//    public static void main(String[] args){
//        //Lucene Document的域名
//        String fieldName = "text";
//        //检索内容
//        String text = "IK Analyzer是一个结合词典分词和文法分词的中文分词开源工具包。它使用了全新的正向迭代最细粒度切分算法。";
//        //实例化IKAnalyzer分词器
//        Analyzer analyzer = new IKAnalyzer();
//        Directory directory = null;
//        IndexWriter iwriter = null;
//        IndexReader ireader = null;
//        IndexSearcher isearcher = null;
//        try {
//            //建立内存索引对象
//            directory = new RAMDirectory();
//            //配置IndexWriterConfig
//            IndexWriterConfig iwConfig = new
//                    IndexWriterConfig(Version.LUCENE_34 , analyzer);
//            iwConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
//            iwriter = new IndexWriter(directory , iwConfig);
//            //写入索引
//            Document doc = new Document();
//            doc.add(new Field("ID", "10000", Field.Store.YES,
//                    Field.Index.NOT_ANALYZED));
//            doc.add(new Field(fieldName, text, Field.Store.YES,
//                    Field.Index.ANALYZED));
//            iwriter.addDocument(doc);
//            iwriter.close();
//            //搜索过程**********************************
//            //实例化搜索器
//            ireader = IndexReader.open(directory);
//            isearcher = new IndexSearcher(ireader);
//            String keyword = "中文分词工具包";
//            //使用QueryParser查询分析器构造Query对象
//            QueryParser qp = new QueryParser(Version.LUCENE_34,
//                    fieldName, analyzer);
//            qp.setDefaultOperator(QueryParser.AND_OPERATOR);
//            Query query = qp.parse(keyword);
//            //搜索相似度最高的5条记录
//            TopDocs topDocs = isearcher.search(query , 5);
//            System.out.println("命中：" + topDocs.totalHits);
//            //输出结果
//            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
//            for (int i = 0; i < topDocs.totalHits; i++){
//                Document targetDoc = isearcher.doc(scoreDocs[i].doc);
//                System.out.println("内容：" + targetDoc.toString());
//            }
//        } catch (CorruptIndexException e) {
//            e.printStackTrace();
//        } catch (LockObtainFailedException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        } finally{
//            if(ireader != null){
//                try {
//                    ireader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(directory != null){
//                try {
//                    directory.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//}


    }
